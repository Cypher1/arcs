load("//third_party/java/arcs/build_defs:build_defs.bzl", "arcs_kt_android_library")

licenses(["notice"])

package(default_visibility = ["//java/arcs:allowed-packages"])

arcs_kt_android_library(
    name = "parcelables",
    srcs = glob(["*.kt"]),
    idl_parcelables = glob(["*.aidl"]),
    manifest = "//java/arcs/android/common:AndroidManifest.xml",
    deps = [
        "//java/arcs/android/type",
        "//java/arcs/core/data",
        "//java/arcs/core/data/expression",
        "//java/arcs/core/host",
        "//java/arcs/core/storage:storage_key",
        "//java/arcs/core/storage/referencemode",
    ],
)
