/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.netbeans.modules.signer.locale;

import java.util.Locale;
import java.util.ResourceBundle;

/**
 * Language support (English and spanish currently supported).
 *
 * @author iherazo
 */
public class LocaleLoader {

  private Locale currentLocale;
  private ResourceBundle rbCurrentLocale;
  private static LocaleLoader localeLoader;

  private LocaleLoader() {
    this.loadLocale(Locale.ENGLISH);
  }

  public static LocaleLoader getInstance() {
    if (localeLoader == null) {
      localeLoader = new LocaleLoader();
    }
    return localeLoader;
  }

  private void loadLocale(Locale newLocale) {
    this.rbCurrentLocale = ResourceBundle.getBundle(
            "org.netbeans.modules.signer.locale.NBSignerLanguage", newLocale);
    this.currentLocale = newLocale;
  }

  public String getValue(String subKey) {
    return this.rbCurrentLocale.getString(
            "org.netbeans.modules.signer.locale." + subKey);
  }

  public void setCurrentLocale(String languageSuffix) {
    this.loadLocale(new Locale(languageSuffix.toLowerCase()));
  }

  public String getLanguage() {
    return this.currentLocale.getLanguage().toLowerCase();
  }
}
