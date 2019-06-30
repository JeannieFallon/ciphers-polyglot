# LC101: Crypto Assignment
import string

def alphabet_position(letter):
    '''receives char and returns 0-based numerical position
    of that letter within alphabet'''
    alphabet = string.ascii_lowercase
    return alphabet.index(letter.lower())


def rotate_character(char,rot):
    '''receives char and degree of rotation (int);
    uses helper function alphabet_position;
    returns new char after rotation'''
    alphabet = string.ascii_lowercase
    new_char = char
    if char.isalpha():
        new_char = alphabet[(alphabet_position(char) + rot) % len(alphabet)]
        if char.isupper():
            new_char = new_char.upper()
    return new_char
