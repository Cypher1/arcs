load(
    "//third_party/java/arcs/build_defs:build_defs.bzl",
    "arcs_kt_library",
)

licenses(["notice"])

package(default_visibility = ["//java/arcs:allowed-packages"])

arcs_kt_library(
    name = "storage",
    srcs = glob(["*.kt"]),
    visibility = ["//java/arcs:allowed-packages"],
    exports = [
        "//java/arcs/core/storage:reference",
        "//java/arcs/core/storage:storage_key",
        "//java/arcs/core/storage/driver:driver_providers",
        "//java/arcs/core/storage/keys",
        "//java/arcs/core/storage/referencemode",
    ],
    deps = [
        "//java/arcs/core/storage:reference",
        "//java/arcs/core/storage:storage_key",
        "//java/arcs/core/storage/driver:driver_providers",
        "//java/arcs/core/storage/keys",
        "//java/arcs/core/storage/referencemode",
    ],
)
