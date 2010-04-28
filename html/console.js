var out = new Object();
out.initConsole = function() {
  element = this.parent || document.body;
  this.console = document.createElement("pre");
  element.appendChild(this.console);
  return this.console;
}
out.print = function(str) {
  var c = this.console || this.initConsole();
  var l = this.line || 20;
  while(c.childNodes.length > l) {
    c.removeChild(c.firstChild);
  }
  c.appendChild(document.createTextNode(str.toString() + "\n"));
}

function p(str) {
  out.print(str)
}
