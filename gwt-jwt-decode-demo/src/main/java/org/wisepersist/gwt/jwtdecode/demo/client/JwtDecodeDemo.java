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

package org.wisepersist.gwt.jwtdecode.demo.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.Style;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.TextArea;
import com.google.gwt.user.client.ui.VerticalPanel;

import org.wisepersist.gwt.jwtdecode.client.Jwt;
import org.wisepersist.gwt.jwtdecode.client.TokenJso;

/**
 * Entry point class which defines <code>onModuleLoad()</code>.
 *
 * @author delight.wjk@gmail.com
 */
public class JwtDecodeDemo implements EntryPoint {

  private TextArea inputArea = buildTextArea();
  private Button btnDecode = buildButton();
  private TextArea outputArea = buildTextArea();

  /**
   * This is the entry point method.
   */
  public final void onModuleLoad() {
    bindHandlers();
    setDefaultToken();
    doLayout();
  }

  /**
   * Binds handlers.
   */
  @SuppressWarnings("IllegalCatch")
  private void bindHandlers() {
    btnDecode.addClickHandler(new ClickHandler() {
      @Override
      public void onClick(final ClickEvent event) {
        final String token = inputArea.getValue();
        try {
          final TokenJso decoded = Jwt.decode(token);
          GWT.log("decoded: " + decoded.toJsonPretty());
          outputArea.setValue(decoded.toJsonPretty());
        } catch (final Exception ex) { //NOPMD
          outputArea.setValue(ex.getMessage());
        }
      }
    });
  }

  /**
   * Sets a default token in the input text ares.
   */
  private void setDefaultToken() {
    inputArea.setValue(
        "eyJhbGciOiJSUzI1NiJ9.eyJzdWIiOiJlbHZpZS53YXJkQGdtYWlsLmNvbSIsImZ0biI6IkxlYSIsImx0biI6"
        + "IkhlYXRoY290ZSIsImxjbCI6ImVuIiwiZXhwIjoxNDkzMzM0MDU4fQ.i3nVmGTskToNIiXgzAbGVEOu-62y"
        + "S5H2P4RQQJlW5v8w1vZBHaeurP71FIRvSUcwrAUXnTnG6LK-bb1K9TtRnP9cI_ehLXp3hZ2tcuR9DICJAJM"
        + "GDSYLyuikaKOv91Qo3ju6AsKmL785llbM4rqUiwLq995roGPaCOX2yu8eLTh8kUKJs-8Y_Mad5aRM4ZefYc"
        + "LZYT3Rvx9ya-NOs8-HUbtHM76cydYiIpQAOPS-WUJdULRuYrQRZ3FM5IpCzJby6LtmTLHMBYKgN1eXOq7Vo"
        + "IOO4bHSgvIEO5RAipiefXvz9zlMKiBQhSV89AHgBU0KjzyjKLll4IjuS-br9jEzOhYxSUl-ZR3x6Ce_ANS3"
        + "GlbupMzMmpCYKAC8EbKANpTo_wufcngvBXDJOsCbycFe8v6U6VSGR9PZNIbNqWjbZA5VhkXTzAwvTKqCR7k"
        + "0cqiCt8loIOsCA-5mPFeRH5o31nf4eJbr7FvPgDLeaV7b6wdctZJewRZI3DQTNn4UY7cuEKsJwjYWMY-zsG"
        + "-qzKqWcm_Hnh-zfF1tI7dId1fOyv3PBZC-zD1E4PVYgrEn-g393jr69Ie7WIXtw0-F8eB_TyodeItG9kQX2"
        + "0lY-jYhB-XsvMWaOUL4WycCgd9s0Ncsw8ttlrnO2OYTTZMlV7yrYgulDLSL7v7gpqB7aWW5sxU");
  }

  /**
   * Layouts widgets.
   */
  private void doLayout() {
    final VerticalPanel panel = new VerticalPanel();
    final int margin = 20;
    panel.getElement().getStyle().setMargin(margin, Style.Unit.PX);
    panel.add(new HTML(
        "<h2>GWT Jwt Decode</h2>"
        + "<a href='https://github.com/jiakuan/gwt-jwt-decode'>"
        + "https://github.com/jiakuan/gwt-jwt-decode</a><br><br>"));
    panel.add(inputArea);
    panel.add(btnDecode);
    panel.add(outputArea);
    RootPanel.get().add(panel);
  }

  /**
   * Builds the decode button which will be used in demo page.
   *
   * @return The decode button which will be used in demo page.
   */
  private Button buildButton() {
    final Button button = new Button("Decode");
    final int margin = 10;
    button.getElement().getStyle().setMarginTop(margin, Style.Unit.PX);
    button.getElement().getStyle().setMarginBottom(margin, Style.Unit.PX);
    return button;
  }

  /**
   * Builds a text area with specific character width and visible lines.
   *
   * @return The text area created.
   */
  private TextArea buildTextArea() {
    final TextArea textArea = new TextArea();
    final int width = 80;
    textArea.setCharacterWidth(width);
    final int lines = 15;
    textArea.setVisibleLines(lines);
    return textArea;
  }
}
