# This file was auto-generated by Fern from our API Definition.

import enum
import typing

T_Result = typing.TypeVar("T_Result")


class ConversionType(str, enum.Enum):
    HTML = "html"
    PDF = "pdf"

    def visit(self, html: typing.Callable[[], T_Result], pdf: typing.Callable[[], T_Result]) -> T_Result:
        if self is ConversionType.HTML:
            return html()
        if self is ConversionType.PDF:
            return pdf()