load(
    "//third_party/java/arcs/build_defs:build_defs.bzl",
    "arcs_kt_jvm_library",
    "arcs_kt_jvm_test_suite",
)

licenses(["notice"])

package(default_visibility = ["//java/arcs:allowed-packages"])

arcs_kt_jvm_test_suite(
    name = "allocator",
    srcs = glob(["*Test.kt"]),
    package = "arcs.core.allocator",
    deps = [
        ":allocator-test-util",
        "//third_party/java/junit:junit-android",
        "//third_party/kotlin/kotlinx_coroutines",
    ],
)

arcs_kt_jvm_library(
    name = "allocator-test-util",
    testonly = 1,
    srcs = [
        "AllocatorTestBase.kt",
    ],
    deps = [
        "//java/arcs/core/allocator",  # buildcleaner: keep
        "//java/arcs/core/common",
        "//java/arcs/core/data",
        "//java/arcs/core/host",
        "//java/arcs/core/storage",
        "//java/arcs/core/storage:storage_key",
        "//java/arcs/core/storage/api",
        "//java/arcs/core/storage/driver:driver_providers",
        "//java/arcs/core/storage/driver:ramdisk",
        "//java/arcs/core/storage/keys",
        "//java/arcs/core/storage/testutil",
        "//java/arcs/core/testutil",
        "//java/arcs/core/type",
        "//java/arcs/core/util",
        "//java/arcs/core/util/testutil",
        "//java/arcs/jvm/host",
        "//java/arcs/jvm/util",
        "//java/arcs/jvm/util/testutil",
        "//java/arcs/sdk",
        "//javatests/arcs/core/host:particle",
        "//javatests/arcs/core/host:plans",
        "//javatests/arcs/core/host:schemas",
        "//javatests/arcs/core/host:testhost",
        "//third_party/java/junit:junit-android",
        "//third_party/java/truth:truth-android",
        "//third_party/kotlin/kotlinx_coroutines",
        "//third_party/kotlin/kotlinx_coroutines:kotlinx_coroutines_test",
    ],
)
