/*
* Licensed to the Apache Software Foundation (ASF) under one
* or more contributor license agreements.  See the NOTICE file
* distributed with this work for additional information
* regarding copyright ownership.  The ASF licenses this file
* to you under the Apache License, Version 2.0 (the
* "License"); you may not use this file except in compliance
* with the License.  You may obtain a copy of the License at
*
*   http://www.apache.org/licenses/LICENSE-2.0
*
* Unless required by applicable law or agreed to in writing,
* software distributed under the License is distributed on an
* "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
* KIND, either express or implied.  See the License for the
* specific language governing permissions and limitations
* under the License.
*/
package org.apache.felix.ipojo.runtime.core.components.mix;

import org.apache.felix.ipojo.annotations.Component;
import org.apache.felix.ipojo.annotations.Context;
import org.apache.felix.ipojo.annotations.Property;
import org.apache.felix.ipojo.annotations.Provides;
import org.apache.felix.ipojo.runtime.core.services.CheckService;
import org.osgi.framework.BundleContext;

import java.util.HashMap;
import java.util.Map;

/**
 * A component using constructor injection to retrieve the bundle context and a property.
 * In this component the property is first.
 */
@Component
@Provides
public class MixWithProperties1 implements CheckService {


    private final String message;
    private final BundleContext context;

    public MixWithProperties1(@Property(name = "message") String message, @Context BundleContext context) {
        this.context = context;
        this.message = message;
    }

    @Override
    public boolean check() {
        return context != null;
    }

    @Override
    public Map map() {
        Map<String, Object> map = new HashMap<String, Object>();
        if (context != null) {
            map.put("context", context);
        }
        if (message != null) {
            map.put("message", message);
        }
        return map;
    }
}
