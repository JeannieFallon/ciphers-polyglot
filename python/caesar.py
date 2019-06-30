# LC101: Crypto assignment
from sys import argv, exit
from helpers import alphabet_position, rotate_character

def encrypt(text, rot):
    '''receives string and degree of rotation (int);
    uses helper function rotate_character to shift
    plaintext by degree specified by rot int;
    returns cipher text as string'''
    cipher_text = ''
    for char in text:
        cipher_text += rotate_character(char, rot)
    #cipher_text += str[rotate_character(char,rot) for char in text]
    return cipher_text


def user_input_is_valid(cl_args):
    if len(cl_args) > 1:
        key = cl_args[1]
        return key.isdigit()
    else:
        return False


def main():
    if user_input_is_valid(argv):
        #plaintext = input('Type a message:\n')
        print(encrypt(plaintext, int(argv[1])))
    else:
        print("usage: python3 caesar.py n")


if __name__ == '__main__':
    main()
