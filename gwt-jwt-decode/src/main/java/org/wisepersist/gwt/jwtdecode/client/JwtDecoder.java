/*
 * Copyright (c) 2016 WisePersist.org
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.wisepersist.gwt.jwtdecode.client;

import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.ScriptInjector;

/**
 * A lightweight GWT wrapper for JWT decode JavaScript library.
 *
 * @author delight.wjk@gmail.com
 * @see <a href="https://github.com/auth0/jwt-decode">https://github.com/auth0/jwt-decode</a>
 */
public class JwtDecoder {

  private static boolean jsInjected;

  /**
   * Protected non-args constructor.
   */
  protected JwtDecoder() {
    // Do nothing here
  }

  /**
   * Decodes a JWT token. This method doesn't validate the token, any well formed JWT can
   * be decoded. You should validate the token in your server-side logic.
   *
   * @param token The JWT token specified.
   * @return The decoded string.
   */
  public static TokenJso decode(final String token) { //NOPMD
    injectJavaScript();
    return doDecode(token);
  }

  /**
   * Calls JWT decode Javascript method to decode.
   *
   * @param token The JWT token string specified.
   * @return The decoded Javascript object.
   */
  private static native TokenJso doDecode(final String token) /*-{
      var decoded = $wnd.jwt_decode(token);
      console.log(decoded);
      return decoded;
  }-*/;

  /**
   * Injects JWT decode JavaScript into page. It will only inject once.
   */
  private static void injectJavaScript() {
    if (!JwtDecoder.jsInjected) {
      final String jwtJs = JsResources.INSTANCE.jwtDecodeMin().getText();
      GWT.log("Injecting JWT JavaScript: " + jwtJs);
      ScriptInjector.fromString(jwtJs)
          .setWindow(ScriptInjector.TOP_WINDOW)
          .setRemoveTag(false)
          .inject();
      JwtDecoder.jsInjected = true;
    }
  }
}
