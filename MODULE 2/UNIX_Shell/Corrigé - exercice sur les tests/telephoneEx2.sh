#!/bin/bash
read -p "Veuillez entrer votre numéro de telephone au format '0nnnnnnnnn': " telephone
if [[ $telephone =~ (^0[0-9]{9}$ | ^\+33[0-9]{9}$) ]]; then
echo "Ce numero est incorrect."
else
echo "Numero enregistré."
echo "Numéro de telephone enregistré : $telephone" >> telephoneResult
fi