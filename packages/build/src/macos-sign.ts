import { promises as fs } from 'fs';
import codesign from 'node-codesign';
import { notarize as nodeNotarize } from 'electron-notarize';
import Config from './config';

const notarize = (bundleId: string, executable: string, user: string, password: string) => {
  return nodeNotarize({
    appBundleId: bundleId,
    appPath: executable,
    appleId: user,
    appleIdPassword: password
  });
};

const sign = (path: string, identity: string) => {
  return new Promise((resolve, reject) => {
    codesign({ identity: identity, appPath: path }, (err, paths) => {
      if (err) {
        reject(err);
      } else {
        resolve(err);
      }
    });
  });
};

const publish = async(executable: string, artifact: string, config: Config) => {
  // Remove the zip that was created since the notarize process will create a
  // new zip.
  console.log('mongosh: removing unsigned zip:', artifact);
  await fs.unlink(artifact);
  console.log('mongosh: signing:', executable);
  await sign(config.outputDir, config.appleAppIdentity).
    catch((e) => { console.error(e); throw e; });
  console.log('mongosh: notarizing and zipping:', executable);
  await notarize(
    config.bundleId,
    executable,
    config.appleUser,
    config.applePassword).catch((e) => { console.error(e); throw e; });
};

export default publish;