<html>
<head>
<title>Client.java</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<style type="text/css">
.s0 { color: #cf8e6d;}
.s1 { color: #bcbec4;}
.s2 { color: #bcbec4;}
.s3 { color: #7a7e85;}
.s4 { color: #2aacb8;}
.s5 { color: #6aab73;}
</style>
</head>
<body bgcolor="#1e1f22">
<table CELLSPACING=0 CELLPADDING=5 COLS=1 WIDTH="100%" BGCOLOR="#606060" >
<tr><td><center>
<font face="Arial, Helvetica" color="#000000">
Client.java</font>
</center></td></tr></table>
<pre><span class="s0">import </span><span class="s1">java</span><span class="s2">.</span><span class="s1">io</span><span class="s2">.*;</span>
<span class="s0">import </span><span class="s1">java</span><span class="s2">.</span><span class="s1">net</span><span class="s2">.*;</span>
<span class="s0">import </span><span class="s1">java</span><span class="s2">.</span><span class="s1">util</span><span class="s2">.</span><span class="s1">Scanner</span><span class="s2">;</span>
<span class="s3">//ALI</span>
<span class="s0">public class </span><span class="s1">Client </span><span class="s2">{</span>
    <span class="s0">public static void </span><span class="s1">main</span><span class="s2">(</span><span class="s1">String</span><span class="s2">[] </span><span class="s1">args</span><span class="s2">) {</span>
        <span class="s1">Scanner scanner </span><span class="s2">= </span><span class="s0">new </span><span class="s1">Scanner</span><span class="s2">(</span><span class="s1">System</span><span class="s2">.</span><span class="s1">in</span><span class="s2">);</span>

        <span class="s1">System</span><span class="s2">.</span><span class="s1">out</span><span class="s2">.</span><span class="s1">println</span><span class="s2">();</span>
        <span class="s1">String serverAddress </span><span class="s2">= </span><span class="s1">scanner</span><span class="s2">.</span><span class="s1">nextLine</span><span class="s2">();</span>

        <span class="s0">try </span><span class="s2">(</span><span class="s1">Socket socket </span><span class="s2">= </span><span class="s0">new </span><span class="s1">Socket</span><span class="s2">(</span><span class="s1">serverAddress</span><span class="s2">, </span><span class="s4">12345</span><span class="s2">);</span>
             <span class="s1">ObjectOutputStream output </span><span class="s2">= </span><span class="s0">new </span><span class="s1">ObjectOutputStream</span><span class="s2">(</span><span class="s1">socket</span><span class="s2">.</span><span class="s1">getOutputStream</span><span class="s2">());</span>
             <span class="s1">ObjectInputStream input </span><span class="s2">= </span><span class="s0">new </span><span class="s1">ObjectInputStream</span><span class="s2">(</span><span class="s1">socket</span><span class="s2">.</span><span class="s1">getInputStream</span><span class="s2">())) {</span>

            <span class="s1">System</span><span class="s2">.</span><span class="s1">out</span><span class="s2">.</span><span class="s1">println</span><span class="s2">(</span><span class="s5">&quot;Connected &quot;</span><span class="s2">);</span>


            <span class="s0">while </span><span class="s2">(</span><span class="s0">true</span><span class="s2">) {</span>

                <span class="s1">System</span><span class="s2">.</span><span class="s1">out</span><span class="s2">.</span><span class="s1">println</span><span class="s2">(</span><span class="s5">&quot; 'Q' to quit:&quot;</span><span class="s2">);</span>
                <span class="s1">String shapeType </span><span class="s2">= </span><span class="s1">scanner</span><span class="s2">.</span><span class="s1">nextLine</span><span class="s2">();</span>

                <span class="s0">if </span><span class="s2">(</span><span class="s1">shapeType</span><span class="s2">.</span><span class="s1">equalsIgnoreCase</span><span class="s2">(</span><span class="s5">&quot;Q&quot;</span><span class="s2">)) {</span>
                    <span class="s1">output</span><span class="s2">.</span><span class="s1">writeObject</span><span class="s2">(</span><span class="s0">null</span><span class="s2">);</span>
                    <span class="s0">break</span><span class="s2">;</span>
                <span class="s2">}</span>

                <span class="s1">Shape shape </span><span class="s2">= </span><span class="s0">null</span><span class="s2">;</span>
                <span class="s0">if </span><span class="s2">(</span><span class="s1">shapeType</span><span class="s2">.</span><span class="s1">equalsIgnoreCase</span><span class="s2">(</span><span class="s5">&quot;Circle&quot;</span><span class="s2">)) {</span>

                    <span class="s1">System</span><span class="s2">.</span><span class="s1">out</span><span class="s2">.</span><span class="s1">println</span><span class="s2">(</span><span class="s5">&quot; radius&quot;</span><span class="s2">);</span>
                    <span class="s0">double </span><span class="s1">radius </span><span class="s2">= </span><span class="s1">scanner</span><span class="s2">.</span><span class="s1">nextDouble</span><span class="s2">();</span>
                    <span class="s1">scanner</span><span class="s2">.</span><span class="s1">nextLine</span><span class="s2">();</span>
                    <span class="s1">shape </span><span class="s2">= </span><span class="s0">new </span><span class="s1">Circle</span><span class="s2">(</span><span class="s1">radius</span><span class="s2">);</span>
                <span class="s2">} </span><span class="s0">else if </span><span class="s2">(</span><span class="s1">shapeType</span><span class="s2">.</span><span class="s1">equalsIgnoreCase</span><span class="s2">(</span><span class="s5">&quot;Rectangle&quot;</span><span class="s2">)) {</span>

                    <span class="s1">System</span><span class="s2">.</span><span class="s1">out</span><span class="s2">.</span><span class="s1">println</span><span class="s2">(</span><span class="s5">&quot;width &quot;</span><span class="s2">);</span>
                    <span class="s0">double </span><span class="s1">width </span><span class="s2">= </span><span class="s1">scanner</span><span class="s2">.</span><span class="s1">nextDouble</span><span class="s2">();</span>
                    <span class="s1">System</span><span class="s2">.</span><span class="s1">out</span><span class="s2">.</span><span class="s1">println</span><span class="s2">(</span><span class="s5">&quot; height&quot;</span><span class="s2">);</span>
                    <span class="s0">double </span><span class="s1">height </span><span class="s2">= </span><span class="s1">scanner</span><span class="s2">.</span><span class="s1">nextDouble</span><span class="s2">();</span>
                    <span class="s1">scanner</span><span class="s2">.</span><span class="s1">nextLine</span><span class="s2">();</span>
                    <span class="s1">shape </span><span class="s2">= </span><span class="s0">new </span><span class="s1">Rectangle</span><span class="s2">(</span><span class="s1">width</span><span class="s2">, </span><span class="s1">height</span><span class="s2">);</span>
                <span class="s2">} </span><span class="s0">else </span><span class="s2">{</span>
                    <span class="s1">System</span><span class="s2">.</span><span class="s1">out</span><span class="s2">.</span><span class="s1">println</span><span class="s2">(</span><span class="s5">&quot;Try again.&quot;</span><span class="s2">);</span>
                    <span class="s0">continue</span><span class="s2">;</span>
                <span class="s2">}</span>

                <span class="s1">output</span><span class="s2">.</span><span class="s1">writeObject</span><span class="s2">(</span><span class="s1">shape</span><span class="s2">);</span>

                <span class="s1">String response </span><span class="s2">= (</span><span class="s1">String</span><span class="s2">) </span><span class="s1">input</span><span class="s2">.</span><span class="s1">readObject</span><span class="s2">();</span>
                <span class="s1">System</span><span class="s2">.</span><span class="s1">out</span><span class="s2">.</span><span class="s1">println</span><span class="s2">(</span><span class="s5">&quot; message:&quot;</span><span class="s2">);</span>
                <span class="s1">System</span><span class="s2">.</span><span class="s1">out</span><span class="s2">.</span><span class="s1">println</span><span class="s2">(</span><span class="s1">response</span><span class="s2">);</span>
            <span class="s2">}</span>
        <span class="s2">} </span><span class="s0">catch </span><span class="s2">(</span><span class="s1">Exception e</span><span class="s2">) {</span>
            <span class="s1">System</span><span class="s2">.</span><span class="s1">out</span><span class="s2">.</span><span class="s1">println</span><span class="s2">(</span><span class="s5">&quot;Client error: &quot; </span><span class="s2">+ </span><span class="s1">e</span><span class="s2">.</span><span class="s1">getMessage</span><span class="s2">());</span>
        <span class="s2">}</span>
    <span class="s2">}</span>
<span class="s2">}</span>
</pre>
</body>
</html>