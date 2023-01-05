export function validateEmptyAndLength3 (value) {
  if (!value) {
    return '*Este campo não pode ser vazio!'
  }
  if (value.length < 3) {
    return '*Este campo precisa ter no minimo 3 caracteres'
  }
  return true
}

export function validateEmptyAndEmail (value) {
  if (!value) {
    return '*Este campo não pode ser vazio!'
  }
  // eslint-disable-next-line
  const isValid = /^[a-z0-9.]{1,64}@[a-z0-9.]{1,64}$/i.test(value)
  if (!isValid) {
    return '*Email incorreto!'
  }
}
