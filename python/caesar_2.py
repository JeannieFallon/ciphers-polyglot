def alphabet_position(letter):
    '''receives char and returns 0-based numerical position
    of that letter within alphabet'''
    position = ord(letter)
    if position > 64 and position < 91: # range for uppercase
        position -= 65
    elif position > 96 and position < 123:  # range for lowercase
        position -= 97
    return position


def rotate_character(char,rot):
    '''receives char and degree of rotation (int);
    uses helper function alphabet_position;
    returns new char after rotation'''
    if char.isalpha():
        position = alphabet_position(char)
        new_position = (position + rot) % 26
        if ord(char) > 64 and ord(char) < 91:
            new_position += 65
        elif ord(char) > 96 and ord(char) < 123:
            new_position += 97
        new_char = chr(new_position)
        return new_char
    else:
        return char

def encrypt(text, rot):
    '''receives string and degree of rotation (int);
    uses helper function rotate_character to shift
    plaintext by degree specified by rot int;
    returns cipher text as string'''
    cipher_text = ''
    for char in text:
        cipher_text = rotate_character(char,rot)
    return cipher_text


plaintext = input('Type a message:\n')
rotation = int(input('Rotate by:\n'))
print(encrypt(plaintext, rotation))
