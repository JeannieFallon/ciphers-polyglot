def get_initials(fullname):
    '''Given a person's name as a string, return the
    person's initials (uppercase)'''
    fullname_split = fullname.split()
    initials = (''.join([name[0] for name in fullname_split])).upper()

    return initials
    #initials = ''
    #for name in fullname_split:
    #    initials += name[0]
    #initials_upper = initials.upper()
    #return initials_upper
# try


user_name = input('What is your full name?\n')

print(get_initials(user_name))
