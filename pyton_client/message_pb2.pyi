from google.protobuf import descriptor as _descriptor
from google.protobuf import message as _message
from typing import ClassVar as _ClassVar, Optional as _Optional

DESCRIPTOR: _descriptor.FileDescriptor

class PingMessage(_message.Message):
    __slots__ = ("id", "message")
    ID_FIELD_NUMBER: _ClassVar[int]
    MESSAGE_FIELD_NUMBER: _ClassVar[int]
    id: int
    message: str
    def __init__(self, id: _Optional[int] = ..., message: _Optional[str] = ...) -> None: ...

class PongMessage(_message.Message):
    __slots__ = ("id", "message", "pingId")
    ID_FIELD_NUMBER: _ClassVar[int]
    MESSAGE_FIELD_NUMBER: _ClassVar[int]
    PINGID_FIELD_NUMBER: _ClassVar[int]
    id: int
    message: str
    pingId: int
    def __init__(self, id: _Optional[int] = ..., message: _Optional[str] = ..., pingId: _Optional[int] = ...) -> None: ...
