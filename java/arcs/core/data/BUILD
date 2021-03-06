load(
    "//third_party/java/arcs/build_defs:build_defs.bzl",
    "arcs_kt_library",
)

licenses(["notice"])

package(default_visibility = ["//java/arcs:allowed-packages"])

ENTITY_SRCS = [
    "FieldName.kt",
    "RawEntity.kt",
]

SCHEMA_FIELDS_SRCS = [
    "SchemaFields.kt",
]

ANNOTATIONS_SRCS = [
    "Annotation.kt",
    "AnnotationParam.kt",
]

REFERENCE_SRCS = [
    "Reference.kt",
]

arcs_kt_library(
    name = "data",
    srcs = glob(
        ["*.kt"],
        exclude = ENTITY_SRCS + SCHEMA_FIELDS_SRCS + REFERENCE_SRCS + ANNOTATIONS_SRCS,
    ),
    exports = [
        ":annotations",
        ":rawentity",
        ":reference",
    ],
    deps = [
        ":annotations",
        ":rawentity",
        ":reference",
        ":schema_fields",
        "//java/arcs/core/common",
        "//java/arcs/core/crdt",
        "//java/arcs/core/data/expression",
        "//java/arcs/core/data/expression:scopes",
        "//java/arcs/core/storage:storage_key",
        "//java/arcs/core/type",
        "//java/arcs/core/util",
        "//third_party/kotlin/kotlinx_coroutines",
    ],
)

arcs_kt_library(
    name = "rawentity",
    srcs = ENTITY_SRCS,
    deps = [
        "//java/arcs/core/common",
    ],
)

arcs_kt_library(
    name = "reference",
    srcs = ["Reference.kt"],
    deps = [
        "//java/arcs/core/common",
        "//java/arcs/core/crdt",
    ],
)

arcs_kt_library(
    name = "schema_fields",
    srcs = SCHEMA_FIELDS_SRCS,
    deps = [
        ":annotations",
        ":rawentity",
        "//java/arcs/core/type",
    ],
)

arcs_kt_library(
    name = "annotations",
    srcs = ANNOTATIONS_SRCS,
    deps = [],
)
