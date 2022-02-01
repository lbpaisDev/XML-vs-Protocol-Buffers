import random
import sys


def main():
    argv = sys.argv[1:]

    try:
        npets = int(argv[0])
        nowners = int(argv[1])
        fileNamePets = argv[2]
        fileNameOws = argv[3]
    except:
        print("Npets Nowners filenamepets filenameowners")
        return

    fout = open(fileNamePets,"w")

    for i in range(npets):
        weight = random.randint(5, 500)
        if i%2 == 0:
            fout.write(str(i) + " " + "pet_"+str(i) + " " + "pet_species_"+str(i) + " " + "F" + " " + str(weight) + " "  + "pet_description_"+str(i) + "\n") 
        else:
            fout.write(str(i) + " " + "pet_"+str(i) + " " + "pet_species_"+str(i) + " " + "M" + " " + str(weight) + " "  + "pet_description_"+str(i) + "\n") 
    fout.close()

    fout = open(fileNameOws,"w")

    for i in range(nowners):
        phone = random.randint(960000000, 969999999)
        fout.write(str(phone) + " " + "owner_address_"+str(i) + " " + "owner_name_"+str(i) + "\n") 
    fout.close()


if __name__ == "__main__":
    main()