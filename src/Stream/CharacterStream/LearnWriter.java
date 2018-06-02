package Stream.CharacterStream;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
// BufferedWriter, CharArrayWriter, FilterWriter,
// OutputStreamWriter, FileWriter, PipedWriter, PrintWriter, StringWriter
//protected	Writer()
//        Creates a new character-stream writer whose critical
// sections will synchronize on the writer itself.
//protected	Writer(Object lock)
//        Creates a new character-stream writer whose critical
// sections will synchronize on the given object.
//Writer	append(char c)
//        Appends the specified character to this writer.
//        Writer	append(CharSequence csq)
//        Appends the specified character sequence to this writer.
//        Writer	append(CharSequence csq, int start, int end)
//        Appends a subsequence of the specified character sequence to this writer.
//abstract void	close()
//        Closes the stream, flushing it first.
//abstract void	flush()
//        Flushes the stream.
//        void	write(char[] cbuf)
//        Writes an array of characters.
//abstract void	write(char[] cbuf, int off, int len)
//        Writes a portion of an array of characters.
//        void	write(int c)
//        Writes a single character.
//        void	write(String str)
//        Writes a string.
//        void	write(String str, int off, int len)
//        Writes a portion of a string.
public class LearnWriter
{
    public static void main(String args[])
    {
        try(Writer w=new FileWriter("/tmp.txt"))
        {
            char[] network={'N','e','t','w','o','r','k'};
            w.write(network,0,network.length);
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }

}
