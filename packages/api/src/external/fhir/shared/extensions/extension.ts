import { BASE_EXTENSION_URL } from "./base-extension";

// TODO #712: create this extension
const DATA_SOURCE_EXTENSION_URL = `${BASE_EXTENSION_URL}/data-source.json`;

export const dataSourceExtensionDefaults = {
  url: DATA_SOURCE_EXTENSION_URL,
  valueCoding: {
    system: DATA_SOURCE_EXTENSION_URL,
  },
};