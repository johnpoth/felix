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

package org.apache.felix.ipojo.runtime.core.test.dependencies;

import org.ops4j.pax.exam.Option;
import org.ops4j.pax.exam.options.CompositeOption;
import org.ops4j.pax.exam.options.DefaultCompositeOption;
import org.ow2.chameleon.testing.helpers.BaseTest;

import java.util.Arrays;
import java.util.List;

import static org.ops4j.pax.exam.CoreOptions.mavenBundle;

/**
 * Bootstrap the test from this project
 */
public class Common extends BaseTest {

    @Override
    protected Option[] getCustomOptions() {
        return new Option[]{
                eventadmin()
        };
    }

    @Override
    protected List<String> getExtraExports() {
        return Arrays.asList(
                "org.apache.felix.ipojo.runtime.core.test.components.inner"
        );
    }

    public CompositeOption eventadmin() {
        return new DefaultCompositeOption(
                mavenBundle("org.apache.felix", "org.apache.felix.eventadmin", "1.3.0"),
                mavenBundle("org.apache.felix", "org.apache.felix.ipojo.handler.eventadmin",
                        "1.8.0").versionAsInProject());
    }

}
