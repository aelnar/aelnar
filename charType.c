#include<stdio.h>
#include<stdlib.h>
#include<ctype.h>
#include<assert.h>
#include<string.h>

#define MAX_STRING_LENGTH 100

// function prototype                                                                                                      
void extract_chars(char* s, char* a, char* d, char* p, char* w);

// function main which takes command line arguments                                                                        
int main(int argc, char* argv[]){
  FILE* in;
  FILE* out;
  char* line;
  char* a;
  char* d;
  char* p;
  char* w;

  // check command line for correct number of arguments                                                                    
  if( argc != 3 ){
    printf("Usage: %s input-file output-file\n", argv[0]);
    exit(EXIT_FAILURE);
  }

  // open input file for reading                                                                                           
  if( (in=fopen(argv[1], "r"))==NULL ){
    printf("Unable to read from file %s\n", argv[1]);
    exit(EXIT_FAILURE);
  }

  // open output file for writing                                                                                          
  if( (out=fopen(argv[2], "w"))==NULL ){
    printf("Unable to write to file %s\n", argv[2]);
    exit(EXIT_FAILURE);
  }

  // allocate strings line                                                                                                 
  line = calloc(MAX_STRING_LENGTH+1, sizeof(char) );
  a = calloc(MAX_STRING_LENGTH+1, sizeof(char) );
  d = calloc(MAX_STRING_LENGTH+1, sizeof(char) );
  p = calloc(MAX_STRING_LENGTH+1, sizeof(char) );
  w = calloc(MAX_STRING_LENGTH+1, sizeof(char) );
  assert( line!=NULL && a!=NULL && d!=NULL && p!=NULL && w!=NULL );

  int lineNum;
  while( fgets(line, MAX_STRING_LENGTH, in) != NULL ){
    lineNum++;
    extract_chars(line, a, d, p, w);
    fprintf(out, "line %d contains:\n", lineNum);
       int one = strlen(a);
    if(one == 1){
      fprintf(out, "%d alphabetic character: %s\n", one, a);}
    else{
      fprintf(out, "%d alphabetic characters: %s\n", one, a);}
    int two = strlen(d);
    if(two == 1){
      fprintf(out, "%d numeric character: %s\n", two, d);
    }
    else{
      fprintf(out, "%d numeric characters: %s\n", two, d);}
    int three = strlen(p);
    if(three == 1){
      fprintf(out, "%d punctuation character: %s\n", three, p);
    }
    else{
      fprintf(out, "%d punctuation characters: %s\n", three, p);}
    int four = strlen(w);
    if(four == 1){
      fprintf(out, "%d whitespace character: %s\n", four, w);
    }
    else{
      fprintf(out, "%d whitespace characters: %s\n", four, w);}
  }

  // free heap memory  
    free(line);
  free(a);
  free(d);
  free(p);
  free(w);

  // close input and output files                                                                                          
  fclose(in);
  fclose(out);

  return EXIT_SUCCESS;
}

// function definition                                                                                                     
void extract_chars(char* s, char* a, char* d, char* p, char* w){
  int i=0, j=0, m=0, n=0, k=0;
  while(s[i]!='\0' && i<MAX_STRING_LENGTH){
    if( isalpha((int) s[i]) ){ a[j++] = s[i];}
    if( isdigit((int) s[i]) ){ d[m++] = s[i];}
    if( ispunct((int) s[i]) ){ p[n++] = s[i];}
    if( isspace((int) s[i]) ){ w[k++] = s[i];}
    i++;
  }
  a[j] = '\0';
  d[m] = '\0';
  p[n] = '\0';
  w[k] = '\0';
}
