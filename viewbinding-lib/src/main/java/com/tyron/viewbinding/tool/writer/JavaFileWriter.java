/*
 * Copyright (C) 2015 The Android Open Source Project
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *      http://www.apache.org/licenses/LICENSE-2.0
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.tyron.viewbinding.tool.writer;

import com.squareup.javapoet.JavaFile;
import com.tyron.viewbinding.tool.util.L;
import com.tyron.viewbinding.tool.util.LoggedErrorException;
import java.io.File;
import java.io.IOException;
import org.apache.commons.io.FileUtils;

public abstract class JavaFileWriter {
  public abstract void writeToFile(String canonicalName, String contents);

  public abstract void deleteFile(String canonicalName);

  public void writeToFile(File exactPath, String contents) {
    try {
      File parent = exactPath.getParentFile();
      parent.mkdirs();
      try {
        L.d("writing file %s", exactPath.getAbsoluteFile());
        FileUtils.writeStringToFile(exactPath, contents, "utf-8");
      } catch (IOException e) {
        L.e(e, "Could not write to %s", exactPath);
      }
    } catch (LoggedErrorException e) {
      // This will be logged later
    }
  }

  public final void writeToFile(JavaFile javafile) {
    writeToFile(javafile.packageName + "." + javafile.typeSpec.name, javafile.toString());
  }
}
