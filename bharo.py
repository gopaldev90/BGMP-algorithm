import os
import zipfile

# Run 
def zip_directory(directory_path, zip_name):
    print(directory_path)
    zipth = os.path.join(directory_path, zip_name)
    bharopth= os.path.join(directory_path, os.path.basename(__file__))
    with zipfile.ZipFile(zip_name, 'w', zipfile.ZIP_DEFLATED) as zipf:
        for root, dirs, files in os.walk(directory_path):
            for file in files:
                file_path = os.path.join(root, file)
                if file_path != zipth and file_path != bharopth:
                    zipf.write(file_path, os.path.relpath(file_path, directory_path))
                    print('bharaa', file_path)


def main():
    mandir = os.getcwd()
    mandir = os.path.join(mandir,'Bholegopalmersenneprime')
    choice=1
    if choice == 1:
        # Pack (zip)
        zip_file_name = os.path.basename(mandir) + '.zip'
        zip_directory(mandir, zip_file_name)
        print(f"Packed '{mandir}' into '{zip_file_name}'.")
        
    
if __name__ == "__main__":
    main()
    