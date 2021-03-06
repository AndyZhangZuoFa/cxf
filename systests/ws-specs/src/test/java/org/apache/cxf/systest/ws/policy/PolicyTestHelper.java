/**
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements. See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership. The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

package org.apache.cxf.systest.ws.policy;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;

import org.apache.cxf.helpers.FileUtils;
import org.apache.cxf.helpers.IOUtils;

/**
 *
 */
public final class PolicyTestHelper {
    private PolicyTestHelper() {

    }


    public static void updatePolicyRef(String file, String oldData,
                                       String newData) throws IOException {
        File f = FileUtils.getDefaultTempDir();
        InputStream in = PolicyTestHelper.class.getResourceAsStream(file);
        String s = IOUtils.readStringFromStream(in);
        s = s.replaceAll(oldData, newData);
        File newFile = new File(f, file);
        FileWriter fw = new FileWriter(newFile);
        fw.write(s);
        fw.close();
    }
}
