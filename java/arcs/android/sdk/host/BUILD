load("//third_party/java/arcs/build_defs:build_defs.bzl", "arcs_kt_android_library")

licenses(["notice"])

package(default_visibility = ["//java/arcs:allowed-packages"])

arcs_kt_android_library(
    name = "host",
    srcs = glob(["*.kt"]),
    manifest = "//java/arcs/android/common:AndroidManifest.xml",
    deps = [
        "//java/arcs/android/host/parcelables",
        "//java/arcs/core/common",
        "//java/arcs/core/data",
        "//java/arcs/core/host",
        "//java/arcs/core/storage",
        "//java/arcs/core/storage:storage_key",
        "//java/arcs/jvm/util",
        "//java/arcs/sdk/android/storage",
        "//third_party/java/androidx/annotation",
        "//third_party/java/androidx/lifecycle",
        "//third_party/java/androidx/lifecycle/service",
        "//third_party/kotlin/kotlin:kotlin_reflect",
        "//third_party/kotlin/kotlinx_coroutines",
    ],
)
