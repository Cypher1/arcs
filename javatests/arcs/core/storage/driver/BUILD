load(
    "//third_party/java/arcs/build_defs:build_defs.bzl",
    "arcs_kt_jvm_test_suite",
)

licenses(["notice"])

package(default_visibility = ["//java/arcs:allowed-packages"])

arcs_kt_jvm_test_suite(
    name = "driver",
    package = "arcs.core.storage.driver",
    deps = [
        "//java/arcs/core/common",
        "//java/arcs/core/crdt",
        "//java/arcs/core/crdt/extension",
        "//java/arcs/core/data",
        "//java/arcs/core/data:schema_fields",
        "//java/arcs/core/data/util:data-util",
        "//java/arcs/core/storage",
        "//java/arcs/core/storage/database",
        "//java/arcs/core/storage/driver:driver_providers",
        "//java/arcs/core/storage/driver:ramdisk",
        "//java/arcs/core/storage/driver/volatiles",
        "//java/arcs/core/storage/driver/volatiles:volatile_impl",
        "//java/arcs/core/storage/keys",
        "//java/arcs/core/testutil",
        "//java/arcs/core/type",
        "//java/arcs/core/util",
        "//java/arcs/core/util/testutil",
        "//java/arcs/jvm/storage/database/testutil",
        "//third_party/java/junit:junit-android",
        "//third_party/java/truth:truth-android",
        "//third_party/kotlin/kotlinx_coroutines",
        "//third_party/kotlin/kotlinx_coroutines:kotlinx_coroutines_test",
    ],
)
