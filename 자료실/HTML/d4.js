class DomTest
{
	constructor(){
	}
	up(){
		var elDiv = document.getElementById("divId");
		var cNodes = elDiv.childNodes;

		//1) create 
		var elFont = document.createElement("font"); //element
		var attrFont = document.createAttribute("style"); //attr
		attrFont.value = "color:red";
		elFont.setAttributeNode(attrFont);
		var txt = document.createTextNode("Happy NewYear"); //text
		elFont.appendChild(txt);

		//2) update
		elDiv.replaceChild(elFont, cNodes[1]);
	}
	del(){
		var elDiv = document.getElementById("divId");
		var cNodes = elDiv.childNodes;

		//3) delete
		elDiv.removeChild(cNodes[0]);
	}
}