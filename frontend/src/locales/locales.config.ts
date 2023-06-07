import { use } from "i18next";
import { initReactI18next } from "react-i18next";

import plTranslation from "./common.pl.json";

export const translationResources = {
  pl: {
    translation: plTranslation
  }
};

use(initReactI18next).init({
  lng: "pl",
  debug: true,
  resources: translationResources
});
