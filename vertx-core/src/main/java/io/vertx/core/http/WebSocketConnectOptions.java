/*
 * Copyright 2014 Red Hat, Inc.
 *
 * Red Hat licenses this file to you under the Apache License, version 2.0
 * (the "License"); you may not use this file except in compliance with the
 * License.  You may obtain a copy of the License at:
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.  See the
 * License for the specific language governing permissions and limitations
 * under the License.
 */

package io.vertx.core.http;

import io.vertx.codegen.annotations.Options;
import io.vertx.core.ServiceHelper;
import io.vertx.core.json.JsonObject;
import io.vertx.core.spi.WebSocketConnectOptionsFactory;

import java.util.Set;

/**
 * @author <a href="http://tfox.org">Tim Fox</a>
 */
@Options
public interface WebSocketConnectOptions extends RequestOptionsBase<WebSocketConnectOptions> {

  static WebSocketConnectOptions options() {
    return factory.options();
  }

  static WebSocketConnectOptions copiedOptions(WebSocketConnectOptions other) {
    return factory.options(other);
  }

  static WebSocketConnectOptions optionsFromJson(JsonObject json) {
    return factory.options(json);
  }

  int getMaxWebsocketFrameSize();

  WebSocketConnectOptions setMaxWebsocketFrameSize(int maxWebsocketFrameSize);

  int getVersion();

  WebSocketConnectOptions setVersion(int version);

  WebSocketConnectOptions addSubProtocol(String subProtocol);

  Set<String> getSubProtocols();

  static final WebSocketConnectOptionsFactory factory = ServiceHelper.loadFactory(WebSocketConnectOptionsFactory.class);

}
