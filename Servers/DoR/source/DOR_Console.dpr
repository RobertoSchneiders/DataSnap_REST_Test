program DOR_Console;

{$IFDEF CONSOLEAPP}
  {$APPTYPE CONSOLE}
{$ENDIF}

{$R *.res}

uses
  madExcept,
  dorService,
  dorSocketStub,
  dorHTTPStub,
  superobject;

type
  THTTPConnection = class(THTTPStub)
  protected
    procedure ProcessRequest; override;
  end;

{ THTTPConnection }

procedure THTTPConnection.ProcessRequest;
begin
  inherited;
  Response.S['Content-Type'] := 'text/plain; charset=utf8';
  Return['result'] := SA(['Hello World!']);
  Render(Return);
  ErrorCode := 200;
end;

begin
  TSocketServer.CreateServer(777, '0.0.0.0', THTTPConnection);
  Application.Name := 'DORRESTSRV';
  Application.DisplayName := 'Delphi On Rails REST Server';
  Application.Run;
end.
