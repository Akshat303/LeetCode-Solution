/**
 * @param {string} s
 * @return {string}
 */
const reorganizeString = function (s) {
  const arr = Array(26).fill(0),
    a = "a".charCodeAt(0);
  for (let ch of s) arr[ch.charCodeAt(0) - a]++;
  let max = 0,
    idx = -1;
  for (let i = 0; i < 26; i++) {
    if (arr[i] > max) {
      max = arr[i];
      idx = i;
    }
  }
  const n = s.length;
  const res = Array(n);
  if (max > (n + 1) / 2) return "";

  let i = 0;
  while (arr[idx] > 0) {
    res[i] = String.fromCharCode(a + idx);
    i += 2;
    arr[idx]--;
  }

  for (let j = 0; j < 26; j++) {
    while (arr[j]) {
      if (i >= n) i = 1;
      res[i] = String.fromCharCode(a + j);
      i += 2;
      arr[j]--;
    }
  }
  return res.join("");
};
