# LC101: Crypto assignment
from helpers import alphabet_position, rotate_character

def encrypt(text,key):
    '''takes two strings, iterate over first with nested
    iteration over second string, changes ordinal value of
    each char in first by 0-26 value of sequential chars in
    second string, returns cipher text of altered first string'''
    cipher_text = ''
    new_key = [alphabet_position(c) for c in key]
    key_length = len(key)
    idx = 0
    for char in text:
        if char.isalpha():
            cipher_text += rotate_character(char,new_key[idx])
            idx = (idx + 1) % key_length
        else:
            cipher_text += char
    return cipher_text

def main():
    #plaintext = input('Type a message:\n')
    #rot_key = (input('Rotate by:\n'))
    print(encrypt(plaintext, rot_key))

if __name__ == '__main__':
    main()
