<%-- 
    Document   : homePage
    Created on : 19-Mar-2024, 11:53:16 am
    Author     : admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="CSS/homeNew.css"/>
        <link href="https://fonts.googleapis.com/css?family=Poppins:100,100italic,200,200italic,300,300italic,regular,italic,500,500italic,600,600italic,700,700italic,800,800italic,900,900italic"
              rel="stylesheet" />
        <script src="JS/index.js" defer></script>

    </head>
    <body>
        <header class="home_header">
            <nav class="home_header_nav">
                <div class="home_header_a">
                    <img src="img/logo/logo.png" alt="logo">
                    <a href="#">Home</a>
                    <a href="services.jsp">Services</a>
                    <a href="help.jsp">Help</a>
                    <a href="team_condition.jsp">Term</a>
                    <a href="contact.jsp">Contact</a>
                </div>
                <div>
                    <button class="home_header_login" onclick="redirecPage('loginPage')">Login now</button>
                </div>
            </nav>
        </header>
        <section class="home_section">
            <div class="home_section_text">
                <div class="home_section_text1">
                    <h2>Make smarter inventory decisions,</h2>
                    <h1>Save time and money</h1>
                    <button>Get Start</button>
                </div>
                <div class="home_section_img">
                    <img src="img/home/integration2-2.png" alt="">
                </div>
            </div>

            <div class="home_wave">
                <svg data-name="Layer 1" xmlns="http://www.w3.org/2000/svg" viewBox="0 0 1200 120"
                     preserveAspectRatio="none">
                <path
                    d="M321.39,56.44c58-10.79,114.16-30.13,172-41.86,82.39-16.72,168.19-17.73,250.45-.39C823.78,31,906.67,72,985.66,92.83c70.05,18.48,146.53,26.09,214.34,3V0H0V27.35A600.21,600.21,0,0,0,321.39,56.44Z"
                    class="shape-fill"></path>
                </svg>
            </div>
        </section>

        <!-- home Container -->
        <div class="home_container">
            <div class="home_container1">
                <div class="home_container1_img">
                    <img src="img/home/17.png" alt="">
                </div>
                <div class="home_container1_txt">
                    <h3>Your inventory,<br>Take control today</h3>
                    <p>Generate bills,Maintain Customer, Vendor <br> Expenses Manage. Daily profit sale Purchase,
                        <br>Track new Customer, new Order, and Stock Identify.
                    </p>
                </div>
            </div>
            <div class="home_containerCenter_main">
                <div class="home_containerCenter">
                    <div class="home_containerCenter_logo">
                        <img src="img/logo/logo.png" alt="logo">
                    </div>
                    <div class="home_containerCenter_txt">
                        Enterprise email, office, files, and <br>meetings—together.
                        <button>Try Now &nbsp;&nbsp;> </button>
                    </div>
                    <div class="home_containerCenter_img">
                        <img src="img/home/zh-announcement-workplace.png" alt="">
                    </div>
                </div>
            </div>
            <div class="home_container2">
                <div class="home_container2_txt">
                    <h3>No extra app <br> required</h3>
                    <p>Real-time control. Maximize profits. (Focuses on efficiency and benefits)<br> Effortless web app. Smart stock control.Your peace of mind. 
                        <br>(Highlights user benefit and ease of use)Next-gen inventory. <br> Future-proof your business. Control what matters.
                    </p>
                </div>
                <div class="home_container2_img">
                    <img src="img/home/library-cta.svg" alt="">
                </div>
            </div>

            <div class="home_container3">
                <div class="home_container3_part1">
                    <div>
                        <h5>
                            Your life's work,<br>
                            powered by our life's work
                        </h5>
                        <p>A unique and powerful software suite to transform the<br> way you work. Designed for businesses
                            of all sizes, built by <br>a company that <span>values your privacy.</span></p>
                        <button>Get Started For Free &nbsp; <span>></span></button>
                    </div>
                        <img src="img/home/home_bg3.jpg" alt="">
                </div>
                <div class="home_container3_part2">
                    <div class="home_container3_part2_details">
                        <label>FEATURE APPS</label>
                        <div class="home_container3_part2_contain">
                            <div class="home_container3_part2_img">
                                <img src="img/home/FEATURE_APP6734392.png" alt="">
                            </div>
                            <div class="home_container3_part2_txt">
                                <h5>Product Management</h5>
                                <p>
                                   Add, edit, and delete inventory items.
                                   Define product details like names,descriptions
                                </p>
                            </div>
                            <div class="home_container3_part2_arr">
                                <span>></span>
                            </div>
                        </div>
                        <div class="home_container3_part2_contain">
                            <div class="home_container3_part2_img">
                                <img src="img/home/FEATURE_APP11932815.png" alt="">
                            </div>
                            <div class="home_container3_part2_txt">
                                <h5>Stock Adjustments</h5>
                                <p>
                                    Allow manual adjustments to inventory levels for reasons like damage, shrinkage, or samples.
                                </p>
                            </div>
                            <div class="home_container3_part2_arr">
                                <span>></span>
                            </div>
                        </div>
                        <div class="home_container3_part2_contain">
                            <div class="home_container3_part2_img">
                                <img src="img/home/FEATURE_APP9070611.png" alt="">
                            </div>
                            <div class="home_container3_part2_txt">
                                <h5>Purchase Orders</h5>
                                <p>
                                    Create and manage purchase orders for new inventory.
                                </p>
                            </div>
                            <div class="home_container3_part2_arr">
                                <span>></span>
                            </div>
                        </div>
                        <div class="home_container3_part2_contain">
                            <div class="home_container3_part2_img">
                                <img src="img/home/FEATURE_APP_4593046.png" alt="">
                            </div>
                            <div class="home_container3_part2_txt">
                                <h5>Inventory Receiving</h5>
                                <p>
                                    Efficiently record incoming inventory, including partial deliveries with the ability to scan barcodes (optional)
                                </p>
                            </div>
                            <div class="home_container3_part2_arr">
                                <span>></span>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <div class="home_container4">
                <img src="img/home/antivirus_11560344.png" alt="">
                <h3>Your privacy is our responsibility</h3>
                <p>We believe that trust is paramount in a relationship. We do not own or sell your data, and we most
                    certainly do not bank on advertising-based business models. The only way we make money is from the
                    software license fees you pay us.</p>
                <button> <img src="img/home/home_bg7.png" alt=""> Watch Video</button>
            </div>

            <div class="home_container5">
                <div class="home_container5_card">
                    <img src="img/home/home_bg4.png" alt="img">
                    <h6>
                        Long-term commitment
                    </h6>
                    <p>25 years of running a profitable organization gives us a good sense of challenges that a growing business faces. We take pride in running a sustainable business that’s powered by you, our customer.</p>
                </div>
                <div class="home_container5_card">
                    <img src="img/home/home_bg5.png" alt="img">
                    <h6>Focus on research & development</h6>
                    <p>Software is our craft and we back it up with our relentless investments in R&D. So much so that we prefer to own the entire technology stack, including running our data centers globally.</p>
                </div>
                <div class="home_container5_card">
                    <img src="img/home/home_bg6.jpg" alt="img">
                    <h6>Customer-first philosophy</h6>
                    <p>In all these years, it's our customers' trust and goodwill that has helped us establish a strong position in the market. No matter the size of your business, we're here to help you grow.</p>
                </div>
            </div>
            <div class="home_container6">

            </div>
            <div class="home_container7">
                <div class="home_container7_txt">
                    <h5>Ready to do your best work?</h5>
                    <p>Let's get you started.</p>
                    <button>SIGN UP NOW &nbsp;></button>

                </div>
            </div>
            <div>

            </div>
        </div>

        <section class="home_section_footer">
            <%@include file="footer.jsp" %>

        </section>
        <script>
            document.addEventListener('scroll', () => {
                const header = document.querySelector('header');
                if (window.scrollY > 0) {
                    header.classList.add('home_scrolled');
                } else {
                    header.classList.remove('home_scrolled');
                }
            });
        </script>
    </body>
</html>
