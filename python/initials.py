def get_initials(fullname):
    '''Given a person's name as a string, return the
    person's initials (uppercase)'''
    fullname_split = fullname.split()
    initials = (''.join([name[0] for name in fullname_split])).upper()

    return initials


#name = input('What is your full name?\n')

#print(get_initials(name))

def main():
    #name = input('What is your full name?\n')
    print(get_initials(name))


if __name__ == '__main__':
    main()
