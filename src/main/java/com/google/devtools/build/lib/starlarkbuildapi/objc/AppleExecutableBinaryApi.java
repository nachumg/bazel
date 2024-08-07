// Copyright 2018 The Bazel Authors. All rights reserved.
//
// Licensed under the Apache License, Version 2.0 (the "License");
// you may not use this file except in compliance with the License.
// You may obtain a copy of the License at
//
//    http://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing, software
// distributed under the License is distributed on an "AS IS" BASIS,
// WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// See the License for the specific language governing permissions and
// limitations under the License.

package com.google.devtools.build.lib.starlarkbuildapi.objc;

import com.google.devtools.build.docgen.annot.DocCategory;
import com.google.devtools.build.lib.packages.semantics.BuildLanguageOptions;
import com.google.devtools.build.lib.starlarkbuildapi.FileApi;
import com.google.devtools.build.lib.starlarkbuildapi.core.StructApi;
import com.google.devtools.build.lib.starlarkbuildapi.cpp.CcInfoApi;
import net.starlark.java.annot.StarlarkBuiltin;
import net.starlark.java.annot.StarlarkMethod;

/**
 * A provider containing the executable binary output that was built using an apple_binary target
 * with the 'executable' type.
 */
@StarlarkBuiltin(
    name = "AppleExecutableBinary",
    category = DocCategory.PROVIDER,
    doc =
        "A provider containing the executable binary output that was built using an "
            + "apple_binary target with the 'executable' type.")
public interface AppleExecutableBinaryApi extends StructApi {

  @StarlarkMethod(
      name = "binary",
      structField = true,
      doc = "The executable binary file output by apple_binary.")
  FileApi getAppleExecutableBinary();

  @StarlarkMethod(
      name = "cc_info",
      structField = true,
      doc =
          "A provider which contains information about the transitive dependencies linked into "
              + "the binary.")
  CcInfoApi<?> getDepsCcInfo();

  @StarlarkMethod(
      name = "objc",
      structField = true,
      doc =
          "A provider which contains information about the transitive dependencies linked into "
              + "the binary.",
      disableWithFlag = BuildLanguageOptions.INCOMPATIBLE_OBJC_PROVIDER_REMOVE_LINKING_INFO)
  ObjcProviderApi<?> getDepsObjcProvider();
}
