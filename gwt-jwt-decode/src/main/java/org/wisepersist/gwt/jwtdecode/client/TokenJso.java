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

import com.google.gwt.core.client.JavaScriptObject;

/**
 * Javascript overlap object for decoded Jwt token.
 *
 * @author delight.wjk@gmail.com
 */
public class TokenJso extends JavaScriptObject {

  /**
   * Overlay types always have protected, zero-arg constructor.
   */
  protected TokenJso() { //NOPMD
    // Do nothing here
  }

  /**
   * Gets object value by object key.
   *
   * @param key The object key specified.
   * @return The object value string.
   */
  public final native String getValue(String key) /*-{
      return this[key];
  }-*/;

  /**
   * Converts to compact Json string.
   *
   * @return The compact Json string of this token object.
   */
  public final native String toJsonCompact() /*-{
      return JSON.stringify(this);
  }-*/;

  /**
   * Converts to pretty Json string.
   *
   * @return The pretty Json string of this token object.
   */
  public final native String toJsonPretty() /*-{
      return JSON.stringify(this, null, 4);
  }-*/;
}
