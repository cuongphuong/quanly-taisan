
const key = 'dsThietBiKho';

export function getLstMaThietBi() {
  return localStorage.getItem(key);
}

export function setLstMaThietBi(value) {
  localStorage.setItem(key, value);
}

export function removeLstMaThietBi() {
  localStorage.removeItem(key);
}