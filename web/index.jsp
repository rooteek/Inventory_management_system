<%-- 
    Document   : index
    Created on : 21-Dec-2023, 5:32:58 pm
    Author     : admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page errorPage="ErrorPage_404.jsp" %>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Home Page</title>
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.2/font/bootstrap-icons.min.css">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
        <link rel="stylesheet" href="CSS/home.css">
    </head>
    <body>
        <nav class="navbar navbar-expand-lg navbar-light bg-light fixed-top">
            <div class="container">
                <a class="navbar-brand" href="#"><span class="text-danger">Product</span>Management</a>
                <button class="navbar-toggler" type="button" data-bs-toggle="collapse"
                        data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false"
                        aria-label="Toggle navigation">
                    <span class="navbar-toggler-icon"></span>
                </button>
                <div class="collapse navbar-collapse" id="navbarSupportedContent">
                    <ul class="navbar-nav ms-auto mb-2 mb-lg-0">

                        <li class="nav-item">
                            <a class="nav-link" href="#">Home</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="#about">About</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="#services">Services</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="#portfolio">Portfolio</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="#team">Team</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="#contact">Contact</a>
                        </li>
                        <li class="nav-item ">
                            <a class="nav-link" href=""></a>
                        </li>
                        <li class="nav-item ">
                            <a class="nav-link" href="singup.jsp">Login</a>
                        </li>
                    </ul>
                </div>
            </div>
        </nav>

        <div id="carouselExampleCaptions" class="carousel slide" data-bs-ride="carousel">
            <div class="carousel-indicators">
                <button type="button" data-bs-target="#carouselExampleCaptions" data-bs-slide-to="0" class="active"
                        aria-current="true" aria-label="Slide 1"></button>
                <button type="button" data-bs-target="#carouselExampleCaptions" data-bs-slide-to="1"
                        aria-label="Slide 2"></button>
                <button type="button" data-bs-target="#carouselExampleCaptions" data-bs-slide-to="2"
                        aria-label="Slide 3"></button>
            </div>
            <div class="carousel-inner">
                <div class="carousel-item active">
                    <img src="img/home/home bg.webp" class="d-block w-100" alt="...">
                    <div class="carousel-caption ">
                        <h5>Your Trust is our Growth</h5>
                        <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Sed ab quis laboriosam iure dicta
                            consectetur!</p>
                        <p><a href="#" class="btn btn-warning mt-3"> Learn More</a></p>
                    </div>
                </div>
                <div class="carousel-item">
                    <img src="img/home/home bg_2.webp" class="d-block w-100" alt="...">
                    <div class="carousel-caption ">
                        <h5>Efficiency in Motion</h5>
                        <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Sed ab quis laboriosam iure dicta
                            consectetur!</p>
                        <p><a href="#" class="btn btn-warning mt-3"> Learn More</a></p>
                    </div>
                </div>
                <div class="carousel-item">
                    <img src="img/home/home bg_3.jpg" class="d-block w-100" alt="...">
                    <div class="carousel-caption">
                        <h5>Streamline Your stock, Boost Your Success!</h5>
                        <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Sed ab quis laboriosam iure dicta
                            consectetur!</p>
                        <p><a href="#" class="btn btn-warning mt-3"> Learn More</a></p>
                    </div>
                </div>
            </div>
            <button class="carousel-control-prev" type="button" data-bs-target="#carouselExampleCaptions"
                    data-bs-slide="prev">
                <span class="carousel-control-prev-icon" aria-hidden="true"></span>
                <span class="visually-hidden">Previous</span>
            </button>
            <button class="carousel-control-next" type="button" data-bs-target="#carouselExampleCaptions"
                    data-bs-slide="next">
                <span class="carousel-control-next-icon" aria-hidden="true"></span>
                <span class="visually-hidden">Next</span>
            </button>
        </div>

        <!-- ================= about section ================= -->
        <section id="about" class="about section-padding" >
            <div class="container">
                <div class="d-flex flex-row ">
                    <div class="col-lg-4 col-md-12 col-12 ">
                        <div class="about-img">
                            <img src="img/home/integration2-2.png" alt="thi image" class="img-fluid updown-animation">
                        </div>
                    </div>
                    <div class="col-lg-8 col-md-12 col-12 ps-lg-5 mt-md-5">
                        <div class="about-text">
                            <h2>We proved Best Quality <br>Service Ever</h2>
                            <p>Lorem ipsum dolor sit amet consectetur adipisicing elit. Temporibus laborum nesciunt,
                                repellendus nulla libero vitae inventore asperiores hic optio neque aspernatur dolorum
                                ducimus officiis pariatur nam quo animi omnis, molestias odio consequuntur aliquam. Ipsa,
                                ipsam ducimus! Similique vitae nesciunt dolor hic veritatis ipsa magni rerum maiores,
                                quisquam tempore consequatur cupiditate!</p>
                            <a href="#" class="btn btn-warning">Learn more</a>
                        </div>
                    </div>
                </div>
            </div>
        </section>

        <!-- ================= service section ================= -->

        <section id="services" class="service section-padding">
            <div class="container">
                <div class="row">
                    <div class="col-md-12">
                        <div class="section-header text-center pb-5">
                            <h2>Our Services</h2>
                            <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. <br> Laboriosam ut esse repellendus
                                maiores dolore itaque.</p>
                        </div>
                    </div>
                </div>
                <div class="row">
                    <div class="col-12 col-md-12 col-lg-4">
                        <div class="card text-white text-center bg-dark pd-2">
                            <div class="card-body">
                                <i class="bi bi-subtract"></i>
                                <h3 class="card-title">Best Quality</h3>
                                <p class="lead">Lorem ipsum dolor sit amet consectetur adipisicing elit. Placeat architecto
                                    nisi
                                    pariatur, dignissimos aspernatur adipisci rem vitae nam aliquam quos. Ab culpa
                                    laboriosam
                                    beatae animi.</p>
                                <button class="btn btn-warning">Read More</button>
                            </div>
                        </div>
                    </div>
                    <div class="col-12 col-md-12 col-lg-4">
                        <div class="card text-white text-center bg-dark pd-2">
                            <div class="card-body">
                                <i class="bi bi-slack"></i>
                                <h3 class="card-title">Sustainability</h3>
                                <p class="lead">Lorem ipsum dolor sit amet consectetur adipisicing elit. Placeat architecto
                                    nisi
                                    pariatur, dignissimos aspernatur adipisci rem vitae nam aliquam quos. Ab culpa
                                    laboriosam
                                    beatae animi.</p>
                                <button class="btn btn-warning">Read More</button>
                            </div>
                        </div>
                    </div>
                    <div class="col-12 col-md-12 col-lg-4">
                        <div class="card text-white text-center bg-dark pd-2">
                            <div class="card-body">
                                <i class="bi bi-playstation"></i>
                                <h3 class="card-title">Integrity</h3>
                                <p class="lead">Lorem ipsum dolor sit amet consectetur adipisicing elit. Placeat architecto
                                    nisi
                                    pariatur, dignissimos aspernatur adipisci rem vitae nam aliquam quos. Ab culpa
                                    laboriosam
                                    beatae animi.</p>
                                <button class="btn btn-warning">Read More</button>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </section>

        <!-- ================= Portfolio section ================= -->

        <section id="portfolio" class="portfolio section-padding">
            <div class="container">
                <div class="row">
                    <div class="col-md-12">
                        <div class="section-header text-center pb-5">
                            <h2>Our Feature</h2>
                            <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. <br> Laboriosam ut esse repellendus
                                maiores dolore itaque.</p>
                        </div>
                    </div>
                </div>
                <div class="row">
                    <div class="col-12 col-md-12 col-lg-4">
                        <div class="card text-light text-center bg-white pb-2">
                            <div class="card-body text-dark">
                                <div class="img-area mb-4">
                                    <img src="img/home/course_1924_image.svg" alt="" class="img-fluid">
                                </div>
                                <h3 class="card-title">Manage you Invoice</h3>
                                <p class="lead">Lorem ipsum dolor sit, amet consectetur adipisicing elit. Porro,
                                    exercitationem unde adipisci qui nihil corporis.</p>
                                <button class="btn bg-warning text-dark">Learn More</button>
                            </div>
                        </div>
                    </div>
                    <div class="col-12 col-md-12 col-lg-4">
                        <div class="card text-light text-center bg-white pb-2">
                            <div class="card-body text-dark">
                                <div class="img-area mb-4">
                                    <img src="img/home/30-2.png" alt="" class="img-fluid">
                                </div>
                                <h3 class="card-title">Stock Management</h3>
                                <p class="lead">Lorem ipsum dolor sit, amet consectetur adipisicing elit. Porro,
                                    </p>
                                <button class="btn bg-warning text-dark">Learn More</button>
                            </div>
                        </div>
                    </div>
                    <div class="col-12 col-md-12 col-lg-4">
                        <div class="card text-light text-center bg-white pb-2">
                            <div class="card-body text-dark">
                                <div class="img-area mb-4">
                                    <img src="img/home/library-cta.svg" alt="" class="img-fluid">
                                </div>
                                <h3 class="card-title">Build Connection</h3>
                                <p class="lead">Lorem ipsum dolor sit, amet consectetur adipisicing elit. Porro, 
                                    exercitationem unde adipisci qui nihil corporis</p>
                                <button class="btn bg-warning text-dark">Learn More</button>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </section>

        <!-- ================= team section ================= -->
        <section id="team" class="team section-padding">
            <div class="container">
                <div class="row">
                    <div class="col-md-12">
                        <div class="section-header text-center pb-5">
                            <h2>Our Team Member</h2>
                            <p>Together, we achieve the extraordinary. Here's to another amazing week of <br> teamwork and innovation! (Encouraging and highlights collaboration)</p>
                        </div>
                    </div>
                </div>
                <center>
                    <div class="row">
                        <div class="col-12 col-md-6 col-lg-3">
                            <div class="card text-center">
                                <div class="card-body">
                                    <img src="img/prifilePhoto/profile4.png" alt="" class="img-fluid rounded-circle">
                                    <h3 class="card-title py-2">Nirav Tikarye</h3>
                                    <p class="card-text">He is a backEnd programmer, he handle all back end activity like business logic and database configuration</p>
                                    <p class="socials">
                                        <i class="bi bi-twitter text-dard mx-1"></i>
                                        <i class="bi bi-facebook text-dard mx-1"></i>
                                        <i class="bi bi-linkedin text-dard mx-1"></i>
                                        <i class="bi bi-instagram text-dard mx-1"></i>
                                    </p>
                                </div>
                            </div>
                        </div>
                        <div class="col-12 col-md-6 col-lg-3">
                            <div class="card text-center">
                                <div class="card-body">
                                    <img src="img/prifilePhoto/profile3.jpeg" alt="" class="img-fluid rounded-circle">
                                    <h3 class="card-title py-2">Mark Chettiyar</h3>
                                    <p class="card-text">He is front end developer, it perform all design and page integration and he also maintain the user data</p>
                                    <p class="socials">
                                        <i class="bi bi-twitter text-dard mx-1"></i>
                                        <i class="bi bi-facebook text-dard mx-1"></i>
                                        <i class="bi bi-linkedin text-dard mx-1"></i>
                                        <i class="bi bi-instagram text-dard mx-1"></i>
                                    </p>
                                </div>
                            </div>
                        </div>
                        <div class="col-12 col-md-6 col-lg-3">
                            <div class="card text-center">
                                <div class="card-body">
                                    <img src="img/prifilePhoto/myCharector.jpeg" alt="" class="img-fluid rounded-circle">
                                    <h3 class="card-title py-2">Rutik Rathod</h3>
                                    <p class="card-text">He is a full stack developer, it perform business as well as back end integration,and valid input check.</p>
                                    <p class="socials">
                                        <i class="bi bi-twitter text-dard mx-1"></i>
                                        <i class="bi bi-facebook text-dard mx-1"></i>
                                        <i class="bi bi-linkedin text-dard mx-1"></i>
                                        <i class="bi bi-instagram text-dard mx-1"></i>
                                    </p>
                                </div>
                            </div>
                        </div>
                    </div>
                </center>

            </div>
        </section>

        <%@include file="GuideLineBrand.jsp" %>


        <!-- ================= contact section ================= -->
        <section id="contact" class="contact section-padding">
            <div class="container">
                <div class="row">
                    <div class="col-md-12">
                        <div class="section-header text-center pb-5">
                            <h2>Contact Us </h2>
                            <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. <br> Laboriosam ut esse repellendus
                                maiores dolore itaque.</p>
                        </div>
                    </div>
                </div>
                <div class="row m-0">
                    <div class="col-md-12 p-0 pt-4 pb-4">
                        <form action="" class="bg-light p-4.m-auto">
                            <div class="row">
                                <div class="col-md-12">
                                    <div class="mb-3">
                                        <input type="text" class="form-control" required placeholder="Your Full name">
                                    </div>
                                </div>
                                <div class="col-md-12">
                                    <div class="mb-3">
                                        <input type="email" class="form-control" required placeholder="Your Email hare">
                                    </div>
                                </div>
                                <div class="col-md-12">
                                    <div class="mb-3">
                                        <textarea name="" rows="3" required class="form-control"
                                                  placeholder="Your Query hare"></textarea>
                                    </div>
                                </div>
                                <button class="btn btn-warning btn-lg btn-block mt-3">Send Now</button>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </section>
        <%@include file="footer.jsp" %>
        <!-- footer -->
        <!--        <footer class="bg-dark p-2 text-center">
                    <div class="container">
                        <p class="text-white">All Right Reserved @webside Name</p>
                       
                    </div>
                </footer>-->


        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
    </body>
</html>
