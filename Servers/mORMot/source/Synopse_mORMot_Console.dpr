program Synopse_mORMot_Console;

{$APPTYPE CONSOLE}

{$R *.res}

uses
  System.SysUtils,
  SynCommons,
  SQLite3Commons,
  SQLite3HttpServer;

type
  TServiceServer = class(TSQLRestServerFullMemory)
  published
    function HelloWorld(var aParams: TSQLRestServerCallBackParams):Integer;
  end;

{ TServiceServer }

function TServiceServer.HelloWorld(
  var aParams: TSQLRestServerCallBackParams): Integer;
begin
  aParams.Resp := JSONEncodeResult(['[Hello World!]']);
  // same as : aResp := JSONEncode(['result',a+b],TempMemoryStream);
  result := 200; // success
end;

var
  Model: TSQLModel;
  Service: TServiceServer;
  Server: TSQLite3HttpServer;
begin
  try
    Model := TSQLModel.Create([], 'service');
    Service := TServiceServer.Create(Model);
    Server := TSQLite3HttpServer.Create('777',[Service], '+',false);

    writeln('Server is running.'#10);
    write('Press [Enter] to close the server.');
    readln;

    Server.Free;
    Service.Free;
    Model.Free;
    { TODO -oUser -cConsole Main : Insert code here }
  except
    on E: Exception do
      Writeln(E.ClassName, ': ', E.Message);
  end;
end.
