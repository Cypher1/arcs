load(
    "//third_party/java/arcs/build_defs:build_defs.bzl",
    "arcs_kt_jvm_test_suite",
)

licenses(["notice"])

package(default_visibility = ["//java/arcs:allowed-packages"])

arcs_kt_jvm_test_suite(
    name = "testutil",
    package = "arcs.core.storage.driver.testutil",
    deps = [
        "//java/arcs/core/common",
        "//java/arcs/core/data",
        "//java/arcs/core/storage:driver",
        "//java/arcs/core/storage:storage_key",
        "//java/arcs/core/storage/driver:driver_providers",
        "//java/arcs/core/storage/driver/testutil",
        "//java/arcs/core/storage/driver/volatiles",
        "//java/arcs/core/storage/driver/volatiles:volatile_impl",
        "//java/arcs/core/storage/keys",
        "//java/arcs/core/storage/referencemode",
        "//third_party/java/junit:junit-android",
        "//third_party/java/truth:truth-android",
        "//third_party/kotlin/kotlinx_coroutines",
        "//third_party/kotlin/kotlinx_coroutines:kotlinx_coroutines_test",
    ],
)
