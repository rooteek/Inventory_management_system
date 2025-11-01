<%-- 
    Document   : help
    Created on : 19-Mar-2024, 7:14:47 pm
    Author     : admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="CSS/help.css"/>
        <link href="https://fonts.googleapis.com/css?family=Poppins:100,100italic,200,200italic,300,300italic,regular,italic,500,500italic,600,600italic,700,700italic,800,800italic,900,900italic" rel="stylesheet" />
        <script src="JS/index.js" defer></script>

    </head>
    <body>
        <header class="help_header">
            <nav class="help_header_nav">
                <div class="help_header_a">
                    <img src="" alt="logo">
                    <a href="homePage.jsp">Home</a>
                    <a href="services.jsp">Services</a>
                    <a href="#">Help</a>
                    <a href="team_condition.jsp">Term</a>
                    <a href="contact.jsp">Contact</a>
                </div>
                <div>
                    <button class="help_header_login" onclick="redirecPage('loginPage')">Login now</button>
                </div>
            </nav>
        </header>
        <section class="help_section">
            <div class="help_section_text">
                <div class="help_section_text1">
                    <h1>A NEW WAY TO MAINTAIN.</h1>
                    <p>With features that <br>protect and <br> innovate</p>
                    <button>Get Start</button>
                </div>
                <div class="help_section_img">
                    <img src="img/help/Browser-2-1.webp" alt="">
                </div>
            </div>

            <div class="custom-shape-divider-bottom-1710766683">
                <svg data-name="Layer 1" xmlns="http://www.w3.org/2000/svg" viewBox="0 0 1200 120"
                     preserveAspectRatio="none">
                <path
                    d="M985.66,92.83C906.67,72,823.78,31,743.84,14.19c-82.26-17.34-168.06-16.33-250.45.39-57.84,11.73-114,31.07-172,41.86A600.21,600.21,0,0,1,0,27.35V120H1200V95.8C1132.19,118.92,1055.71,111.31,985.66,92.83Z"
                    class="shape-fill"></path>
                </svg>
            </div>
        </section>
        <section class="help_section2">
            <div class="help_section2_txt">
                <h3>Shields</h3>
                <p>Shields are the core feature that sets Brave apart <br> from other browsers. Shields offer default, built-in<br> protection, blocking ads, trackers, fingerprinting,<br> cookies, and more. You can easily customize your<br> Shields settings, or enjoy out-of-the-box protection.</p>
                <a href="">Learn more about Shields</a>
            </div>
            <div class="help_section2_img">
                <img src="img/help/WhatsApp Image 2024-03-13 at 11.28.33_81ff364a.jpg" alt="">
            </div>
        </section>
        <section class="help_section2">
            <div class="help_section2_img">
                <img src="img/help/WhatsApp Image 2024-03-13 at 11.28.34_05d9e20c.jpg" alt="">
            </div>
            <div class="help_section2_txt">
                <h3>Brave Search</h3>
                <p>The fastest growing search engine since Bing,<br> built on a fully independent index of the Web.<br> Private and user-first, Brave Search doesn’t track <br>you, your queries, or your clicks.</p>
                <a href="">Learn more about Shields</a>
            </div>
        </section>
        <section class="help_section2">
            <div class="help_section2_txt">
                <h3>Rewards / BAT</h3>
                <p>Opt in to earn BAT rewards for viewing privacy-preserving <br> ads in Brave. Use BAT to support <br> creators, or redeem for gift cards, crypto, and more.</p>
                <a href="">Learn more about Shields</a>
            </div>
            <div class="help_section2_img">
                <img src="img/help/WhatsApp Image 2024-03-13 at 11.28.35_63424e7e.jpg" alt="">
            </div>
        </section>
        <section class="help_section2">
            <div class="help_section2_img">
                <img src="img/help/WhatsApp Image 2024-03-13 at 11.28.35_7b88482a.jpg" alt="">
            </div>
            <div class="help_section2_txt">
                <h3>Wallet</h3>
                <p>A self-custody crypto wallet—and passport to <br> Web3—built with the security of Brave. <br>Browser-native, no extensions required.</p>
                <a href="">Learn more about Shields</a>
            </div>
        </section>
        <section class="help_section2">
            <div class="help_section2_txt">
                <h3>Talk</h3>
                <p>Unlimited, private video calls built right into your <br> browser—no extra downloads, no tracking.</p>
                <a href="">Learn more about Shields</a>
            </div>
            <div class="help_section2_img">
                <img src="img/help/WhatsApp Image 2024-03-13 at 11.28.34_c70e809e.jpg" alt="">
            </div>
        </section>
        <section class="help_section2">
            <div class="help_section2_img">
                <img src="img/help/Browser-2-1.webp" alt="">
            </div>
            <div class="help_section2_txt">
                <h3>News</h3>
                <p>A home page news feed that’s customizable,<br> private, and free from tracking.</p>
                <a href="">Learn more about Shields</a>
                <p>To get started, open a new tab in Brave  and <br> scroll/swipe up</p>
            </div>
        </section>

        <section class="">
            <%@include file="footer.jsp" %>
        </section>
        <script>
            document.addEventListener('scroll', () => {
                const header = document.querySelector('header');
                if (window.scrollY > 0) {
                    header.classList.add('help_scrolled');
                } else {
                    header.classList.remove('help_scrolled');
                }
            });
        </script>

    </body>
</html>
