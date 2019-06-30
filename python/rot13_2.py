#!/usr/bin/env python3
# -*- coding: utf-8 -*-
"""
Created on Tue Nov 29 22:26:41 2016

@author: jeannie
"""
# LC101: Chap 9, string exercises

# 29nov16: close, but need adjustment

def rot13(mess):
    # Your code here
    cipher = ''
    for char in mess:
        if char.isalpha():
            value = ord(char)
            if value > 96 and value < 123: # range for lowercase
                newValue = (value + 13) % 123
                if newValue < 97:
                    newValue += 97
                cipherChar = chr(newValue)
                cipher += cipherChar
            elif value > 64 and value < 91: # range for uppercase
                newValue = (value + 13) % 91
                if newValue < 65:
                    newValue += 65
                cipherChar = chr(newValue)
                cipher += cipherChar
        else:
            cipher += char
    return cipher


print(rot13('abcde'))
print(rot13('nopqr'))
print(rot13(rot13('Since rot13 is symmetric you should see this message')))
print(rot13(rot13('ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijlkmnopqrstuvwxyz')))
