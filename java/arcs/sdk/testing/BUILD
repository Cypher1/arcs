load("//third_party/java/arcs/build_defs:build_defs.bzl", "arcs_kt_jvm_library")

licenses(["notice"])

package(default_visibility = ["//java/arcs:allowed-packages"])

arcs_kt_jvm_library(
    name = "testing",
    testonly = 1,
    srcs = glob(["*.kt"]),
    deps = [
        "//java/arcs/core/host",
        "//java/arcs/core/storage",
        "//java/arcs/core/storage/driver:ramdisk",
        "//java/arcs/core/storage/testutil",
        "//java/arcs/core/util",
        "//java/arcs/jvm/util",
        "//java/arcs/sdk",
        "//java/arcs/sdk/storage",
        "//third_party/java/junit:junit-android",
        "//third_party/java/truth:truth-android",
        "//third_party/kotlin/kotlinx_coroutines",
        "//third_party/kotlin/kotlinx_coroutines:kotlinx_coroutines_test",
    ],
)
