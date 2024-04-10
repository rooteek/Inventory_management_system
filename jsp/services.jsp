<%-- 
    Document   : services
    Created on : 19-Mar-2024, 6:49:37 pm
    Author     : admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="CSS/services.css"/>
        <link href="https://fonts.googleapis.com/css?family=Poppins:100,100italic,200,200italic,300,300italic,regular,italic,500,500italic,600,600italic,700,700italic,800,800italic,900,900italic"
              rel="stylesheet" />
        <script src="JS/index.js" defer></script>

    </head>
    <body>
        <header class="service_header">
            <nav class="service_header_nav">
                <div class="service_header_a">
                    <img src="" alt="logo">
                    <a href="homePage.jsp">Home</a>
                    <a href="#">Services</a>
                    <a href="help.jsp">Help</a>
                    <a href="team_condition.jsp">Term</a>
                    <a href="contact.jsp">Contact</a>
                </div>
                <div>
                    <button class="service_header_login" onclick="redirecPage('loginPage')">Login now</button>
                </div>
            </nav>
        </header>
        <section class="service_section">
            <div class="service_section_text">
                <div class="service_section_text1">
                    <h2>Inventory Management</h2>
                    <h4>Services</h4>
                    <p>Security, Easily Acceseble, right in your browser. No extra apps. Inventory tracking. Just free connections, powered by Rut</p>
                    <button>Get Start</button>
                </div>
            </div>

        </section>
        <section class="service_section2">
            <div class="service_section_text">
                <div class="service_section_text1">
                    <h3>Best Services & fuctinality</h3>
                </div>
                <div class="service_section_img">
                    <img src="" alt="">
                </div>
            </div>
            <div class="custom-shape-divider-top-1710661745">
                <svg data-name="Layer 1" xmlns="http://www.w3.org/2000/svg" viewBox="0 0 1200 120"
                     preserveAspectRatio="none">
                <path
                    d="M321.39,56.44c58-10.79,114.16-30.13,172-41.86,82.39-16.72,168.19-17.73,250.45-.39C823.78,31,906.67,72,985.66,92.83c70.05,18.48,146.53,26.09,214.34,3V0H0V27.35A600.21,600.21,0,0,0,321.39,56.44Z"
                    class="shape-fill"></path>
                </svg>
            </div>
        </section>
        <section class="service_section3">
            <div class="service_section3_container">
                <div class="service_section3_img">
                    <h5>Ensure high availability of your services</h5>
                    <p>Implement best practice IT service management with ServiceDesk Plus' full-stack ITSM suite</p>
                    <img src="img/services/servi_img1.webp" alt="">
                </div>
                <div class="service_section3_txt">
                    <div class="service_section3_txt_details">
                        <img src="img/services/sign1.png" alt="">
                        <h4>Incident management</h4>
                        <p>Reduce outages, improve agent productivity, meet SLAs, and manage the complete life cycle of IT tickets.</p>
                    </div>
                    <div class="service_section3_txt_details">
                        <img src="img/services/sign2.png" alt="">
                        <h4>Asset management</h4>
                        <p>Optimize asset utilization, avoid vulnerabilities, and ensure license compliance.</p>
                    </div>
                    <div class="service_section3_txt_details">
                        <img src="img/services/sign3.png" alt="">
                        <h4>Project management</h4>
                        <p>Create projects, manage resources, track progress, and integrate projects with requests and changes to fine-tune your overall IT service delivery.</p>
                    </div>
                    <div class="service_section3_txt_details">
                        <img src="img/services/sign4.png" alt="">
                        <h4>Problem management</h4>
                        <p>Analyze root causes, reduce repeat incidents, and boost your IT help desk's productivity.</p>
                    </div>
                    <div class="service_section3_txt_details">
                        <img src="img/services/sign5.png" alt="">
                        <h4>CMDB</h4>
                        <p>Visually build relationships between CIs and analyze the business impact of any outages or change implementations.</p>
                    </div>
                    <div class="service_section3_txt_details">
                        <img src="img/services/sign6.png" alt="">
                        <h4>Service catalog</h4>
                        <p>Showcase your available services to end users, with custom SLAs and multi-stage approvals.</p>
                    </div>
                    <div class="service_section3_txt_details">
                        <img src="img/services/sign7.png" alt="">
                        <h4>Change management</h4>
                        <p>Streamline planning, approval, and implementation with automated workflows.</p>
                    </div>
                    <div class="service_section3_txt_details">
                        <img src="img/services/sign8.png" alt="">
                        <h4>Enterprise service management</h4>
                        <p>Extend proven ITSM best practices to HR, finance, and other service delivery areas.</p>
                    </div>
                    <div class="service_section3_txt_details">
                        <img src="img/services/sign9.png" alt="">
                        <h4>IT release management</h4>
                        <p>Make your releases work in tandem with your change management process.</p>
                    </div>
                </div>
            </div>
        </section>
        <section class="service_section4">

        </section>
        <footer>
            <%@include file="footer.jsp" %>
        </footer>
        <script>
            document.addEventListener('scroll', () => {
                const header = document.querySelector('header');
                if (window.scrollY > 0) {
                    header.classList.add('service_scrolled');
                } else {
                    header.classList.remove('service_scrolled');
                }
            });
        </script>
        <script src="index.js"></script>
    </body>
</html>
