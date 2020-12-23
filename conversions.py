# converts grams to cups, tbsp, and tsp of a dry ingredient
# conversion depends on whether or not it's: flour, sugar, powdered sugar,
# cornstartch, cocoa powder, baking powder, or baking soda
# returns those three conversions
# grams: amount in grams given
# ing: the ingredient
def convertDry(grams, ing):
    
    grams = int(grams) # gotta do this for some reason
    
    if ing == 'flour': # 1tbsp = 10g
    
        tbsp = grams / 10
        tsp = tbsp / 3
        cup = tbsp / 16
        
        print("Cups:", cup)
        print("Tbsp:", tbsp)
        print("Tsp:", tsp)
        
    elif ing == 'brown sugar': # 1tbsp = 16g
    
        tbsp = grams / 16
        tsp = tbsp / 3
        cup = tbsp / 16
        
        print("Cups: ", cup)
        print("Tbsp: ", tbsp)
        print("Tsp: ", tsp)
        
    elif ing == 'sugar': # 1tbsp = 14g
    
        tbsp = grams / 14
        tsp = tbsp / 3
        cup = tbsp / 16
        
        print("Cups: ", cup)
        print("Tbsp: ", tbsp)
        print("Tsp: ", tsp)    
    
    elif ing == 'powdered sugar': # 1tbsp = 10g
        
        tbsp = grams / 10
        tsp = tbsp / 3
        cup = tbsp / 16
        
        print("Cups: ", cup)
        print("Tbsp: ", tbsp)
        print("Tsp: ", tsp)
        
    elif ing == 'cornstarch': # 1tbsp = 7g
    
        tbsp = grams / 7
        tsp = tbsp / 3
        cup = tbsp / 16
        
        print("Cups: ", cup)
        print("Tbsp: ", tbsp)
        print("Tsp: ", tsp)
        
    elif ing == 'cocoa powder': # 1tbsp = 6g
    
        tbsp = grams / 6
        tsp = tbsp / 3
        cup = tbsp / 16
        
        print("Cups: ", cup)
        print("Tbsp: ", tbsp)
        print("Tsp: ", tsp)
        
    elif ing == 'baking powder': # 1tbsp = 12g
    
        tbsp = grams / 12
        tsp = tbsp / 3
        cup = tbsp / 16
        
        print("Cups: ", cup)
        print("Tbsp: ", tbsp)
        print("Tsp: ", tsp)
        
    elif ing == 'baking soda': # 1tbsp = 18g
    
        tbsp = grams / 18
        tsp = tbsp / 3
        cup = tbsp / 16
        
        print("Cups: ", cup)
        print("Tbsp: ", tbsp)
        print("Tsp: ", tsp)
    

# converts grams to cups, tbsp, and tsp of a dry ingredient
# conversion depends on whether or not it's: oil, milk, butter, heavy whipping cream, buttermilk, or water
# returns those three conversions
# grams: amount in grams given
# ing: the ingredient
def convertWet(grams, ing):
    
    grams = int(grams)
    
    if ing == 'oil': # 1tbsp = 13g
    
        tbsp = grams / 13
        tsp = tbsp / 3
        cup = tbsp / 16
        
        print("Cups: ", cup)
        print("Tbsp: ", tbsp)
        print("Tsp: ", tsp)
        
    elif ing == 'milk': # 1tbsp = 15g
    
        tbsp = grams / 15
        tsp = tbsp / 3
        cup = tbsp / 16
        
        print("Cups: ", cup)
        print("Tbsp: ", tbsp)
        print("Tsp: ", tsp)
        
    elif ing == 'butter': # 1tbsp = 14g
    
        tbsp = grams / 14
        tsp = tbsp / 3
        cup = tbsp / 16
        
        print("Cups: ", cup)
        print("Tbsp: ", tbsp)
        print("Tsp: ", tsp)
        
    elif ing == 'water': # 1tbsp = 15g
    
        tbsp = grams / 15
        tsp = tbsp / 3
        cup = tbsp / 16
        
        print("Cups: ", cup)
        print("Tbsp: ", tbsp)
        print("Tsp: ", tsp)
        
    elif ing == 'heavy whipping cream': # 1tbsp = 14.44g
    
        tbsp = grams / 14.44
        tsp = tbsp / 3
        cup = tbsp / 16
        
        print("Cups: ", cup)
        print("Tbsp: ", tbsp)
        print("Tsp: ", tsp)
        
    elif ing == 'buttermilk': # 1tbsp = 15.1g

        tbsp = grams / 15.1
        tsp = tbsp / 3
        cup = tbsp / 16
        
        print("Cups: ", cup)
        print("Tbsp: ", tbsp)
        print("Tsp: ", tsp)
    
    
    
# main function
if __name__ == '__main__':
    
    print("Grams to Cups/Tablespoon/Teaspoon Converter")
    print("Can take dry or wet ingredients!")
    
    keepConverting = True
    
    # while there's user input
    while keepConverting is True:
        
        grams = input("Enter the amount of grams to convert (just the number): ")
        
        # gets whether or not it's a dry or wet ingridient
        dw = input("Is it a wet or dry ingredient? (dry/wet): ")
        
        if dw == 'dry':
            
            print("Available conversions for dry ingredients: ")
            print("flour, brown sugar, sugar, powdered sugar, cornstarch, cocoa powder, baking powder, baking soda")
            ing = input("Which ingredient will be converted? (enter the ingredient like how it's written on here): ")
            
            convertDry(grams, ing)
            
        else:
            
            print("Available conversions for wet ingredients: ")
            print("oil, water, milk, butter, heavy whipping cream, buttermilk")
            ing = input("Which ingredient will be converted? (enter the ingredient like how it's written on here): ")

            
            convertWet(grams, ing)
            
        
        cont = input("Would you like to convert something else? (y/n): ")
        
        if cont == 'n': # exit out of loop
            keepConverting = False
            
            
            
        