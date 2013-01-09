unit ServerMethodsUnit1;

interface

uses System.SysUtils, System.Classes, Datasnap.DSServer, Datasnap.DSAuth;

type
{$METHODINFO ON}
  TServerMethods1 = class(TComponent)
  private
    { Private declarations }
  public
    { Public declarations }
    function HelloWorld:String;
  end;
{$METHODINFO OFF}

implementation


uses System.StrUtils, DataSnap.DSSession, Data.DBXPlatform;


function TServerMethods1.HelloWorld: String;
begin
  Result := 'Hello World';
  GetInvocationMetaData.CloseSession := True;
end;
end.

