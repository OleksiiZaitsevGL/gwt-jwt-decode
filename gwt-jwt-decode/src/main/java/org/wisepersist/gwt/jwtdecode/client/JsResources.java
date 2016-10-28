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
import com.google.gwt.resources.client.ClientBundle;
import com.google.gwt.resources.client.TextResource;

/**
 * This class provides Javascript resources, which will then be injected into host pages.
 *
 * @author delight.wjk@gmail.com
 */
public interface JsResources extends ClientBundle {

  /**
   * Instance of {@link JsResources} class.
   */
  JsResources INSTANCE = GWT.create(JsResources.class);

  /**
   * Loads JWT-decode Javascript file as a {@link TextResource} object.
   *
   * @return The {@link TextResource} object of JWT-decode Javascript file.
   */
  @Source("jwt-decode.min.js")
  TextResource jwtDecodeMin();
}
