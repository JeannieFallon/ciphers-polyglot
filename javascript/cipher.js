function clearKey(id) {
  document.getElementById(id).value = "";
}

function getIdxLower(code) {
  return code - 97;
}

function getIdxUpper(code) {
  return code - 65;
}

function getCodeLower(idx) {
  return idx + 97;
}

function getCodeUpper(idx) {
  return idx + 65;
}

function getRotIdx(idx, key) {
  var newIdx = (idx + key) % 26;
  return newIdx;
}

function goCaesar(txtId, keyId) {
  var plnStr = document.getElementById(txtId).value;
  var cphStr = "";
  var key = parseInt(document.getElementById(keyId).value);
  var char = "";
  var code = 0;
  var idx = 0;

  for (var i = 0; i < plnStr.length; i++) {
    code = plnStr.charCodeAt(i);

    if (code >= 97 && code <= 122) {
      idx = getIdxLower(code);
      var newIdx = getRotIdx(idx, key);
      code = getCodeLower(newIdx);
    } else if (code >= 65 && code <= 90) {
      idx = getIdxUpper(code);
      var newIdx = getRotIdx(idx, key);
      code = getCodeUpper(newIdx);
    }

    char = String.fromCharCode(code);
    cphStr += char;
  }

  document.getElementById('ciphertext').innerHTML = cphStr;
}
