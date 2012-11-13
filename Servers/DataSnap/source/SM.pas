unit SM;

interface

uses System.SysUtils, System.Classes, Datasnap.DSServer, Datasnap.DSAuth;

type
{$METHODINFO ON}
  TServerMethods1 = class(TComponent)
  private
    { Private declarations }
  public
    { Public declarations }
    function HelloWorld:string;
    function EchoString(AValue:String):String;
  end;
{$METHODINFO OFF}

implementation


uses System.StrUtils;

function TServerMethods1.EchoString(AValue: String): String;
begin
  Result := AValue;
end;

function TServerMethods1.HelloWorld: string;
begin
  Result := 'Hello World!';
end;

end.

