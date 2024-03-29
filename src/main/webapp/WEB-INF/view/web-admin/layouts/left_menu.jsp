<div class="navbar-default sidebar" role="navigation">
    <div class="sidebar-nav navbar-collapse">
        <ul class="nav" id="side-menu">
            <li>
                <a href="index.html">Dashboard</a>
            </li>
            <li>
                <a href="#">Film Programming<span class="fa arrow"></span></a>
                <ul class="nav nav-second-level">
                    <li>
                        <a href="#">Distributor <span class="fa arrow"></span></a>
                        <ul class="nav nav-third-level collapse">
                            <li>
                                <a href="<c:url value="/admin/distributor/all" />">All Distributor</a>
                            </li>
                            <li>
                                <a href="<c:url value="/admin/distributor/create" />">Create Distributor</a>
                            </li>
                        </ul>
                    </li>
                    <li>
                        <a href="#">Screen<span class="fa arrow"></span></a>
                        <ul class="nav nav-third-level collapse">
                            <li>
                                <a href="<c:url value="/admin/screen/all" />">All screen</a>
                            </li>
                            <li>
                                <a href="<c:url value="/admin/screen/create" />">Create screen</a>
                            </li>

                        </ul>
                        <!-- /.nav-second-level -->
                    </li>
                    <li>
                        <a href="#">Terminal<span class="fa arrow"></span></a>
                        <ul class="nav nav-third-level collapse">
                            <li>
                                <a href="<c:url value="/admin/terminal/all" />">All Terminal</a>
                            </li>
                            <li>
                                <a href="<c:url value="/admin/terminal/create" />">Create Terminal</a>
                            </li>

                        </ul>
                        <!-- /.nav-second-level -->
                    </li>
                    <li>
                        <a href="<c:url value="/admin/circuit/index"/>">Circuit</a>
                    </li>
                    <li>
                        <a href="#">Seat Type<span class="fa arrow"></span></a>
                        <ul class="nav nav-third-level collapse">
                            <li>
                                <a href="<c:url value="/admin/seat-type/all" />">All Seat Type</a>
                            </li>
                            <li>
                                <a href="<c:url value="/admin/seat-type/create" />">Create Seat Type</a>
                            </li>

                        </ul>
                        <!-- /.nav-second-level -->
                    </li>
                    <li>
                        <a href="#">Seat Price Shift<span class="fa arrow"></span></a>
                        <ul class="nav nav-second-level collapse">
                            <li>
                                <a href="<c:url value="/admin/seat-price-shift/all" />">All</a>
                            </li>
                            <li>
                                <a href="<c:url value="/admin/seat-price-shift/create" />">Create</a>
                            </li>
                        </ul>
                        <!-- /.nav-second-level -->
                    </li>
                    <li>
                        <a href="#">Film Genre<span class="fa arrow"></span></a>
                        <ul class="nav nav-third-level collapse">
                            <li>
                                <a href="<c:url value="/admin/genre/all" />">All Genre</a>
                            </li>
                            <li>
                                <a href="<c:url value="/admin/genre/create" />">Create Genre</a>
                            </li>

                        </ul>
                        <!-- /.nav-second-level -->
                    </li>
                    <li>
                        <a href="#">Film<span class="fa arrow"></span></a>
                        <ul class="nav nav-third-level collapse">
                            <li>
                                <a href="<c:url value="/admin/film/all" />">All Films</a>
                            </li>
                            <li>
                                <a href="<c:url value="/admin/film/create" />">Create Film</a>
                            </li>

                        </ul>
                        <!-- /.nav-second-level -->
                    </li>
                    <li>
                        <a href="#">Scheduling film<span class="fa arrow"></span></a>
                        <ul class="nav nav-third-level collapse">
                            <li>
                                <a href="<c:url value="/admin/film-scheduling/all" />">All</a>
                            </li>
                            <li>
                                <a href="<c:url value="/admin/film-scheduling/manage" />">Manage</a>
                            </li>
                            <li>
                                <a href="<c:url value="/admin/ticket/create" />">Create ticket</a>
                            </li>
                        </ul>
                        <!-- /.nav-second-level -->
                    </li>
                </ul>
                <!-- /.nav-second-level -->
            </li>

            <li>
                <a href="#">Concession<span class="fa arrow"></span></a>
                <ul class="nav nav-second-level">
                    <li>
                        <a href="#">Combo<span class="fa arrow"></span></a>
                        <ul class="nav nav-third-level collapse">
                            <li>
                                <a href="<c:url value="/admin/combo/all" />">All Combo</a>
                            </li>
                            <li>
                                <a href="<c:url value="/admin/combo/create" />">Create Combo</a>
                            </li>
                        </ul>
                    </li>
                    <li>
                        <a href="#">Product Category<span class="fa arrow"></span></a>
                        <ul class="nav nav-third-level collapse">
                            <li>
                                <a href="<c:url value="/admin/product-category/all" />">All product category</a>
                            </li>
                            <li>
                                <a href="<c:url value="/admin/product-category/create" />">Create product category</a>
                            </li>

                        </ul>
                        <!-- /.nav-second-level -->
                    </li>
                    <li>
                        <a href="#">Product<span class="fa arrow"></span></a>
                        <ul class="nav nav-third-level collapse">
                            <li>
                                <a href="<c:url value="/admin/concession-product/all" />">All product</a>
                            </li>
                            <li>
                                <a href="<c:url value="/admin/concession-product/create" />">Create product</a>
                            </li>

                        </ul>
                        <!-- /.nav-second-level -->
                    </li>
                    <li>
                        <a href="#">Concession Product Price Shift<span class="fa arrow"></span></a>
                        <ul class="nav nav-third-level collapse">
                            <li>
                                <a href="<c:url value="/admin/concession-price-shift/all" />">All</a>
                            </li>
                            <li>
                                <a href="<c:url value="/admin/concession-price-shift/create" />">Create</a>
                            </li>

                        </ul>
                        <!-- /.nav-second-level -->
                    </li>
                 </ul>
            </li>
            <li>
                <a href="#">System<span class="fa arrow"></span></a>
                <ul class="nav nav-second-level">
                    <li>
                        <a href="<c:url value="/admin/vat-setting/index"/>">Vat Setting</a>
                    </li>
                    <li>
                        <a href="#">Admin<span class="fa arrow"></span></a>
                        <ul class="nav nav-third-level collapse">
                            <li>
                                <a href="<c:url value="/admin/user/all" />">All admin</a>
                            </li>
                            <li>
                                <a href="<c:url value="/admin/user/create" />">Create admin</a>
                            </li>

                        </ul>
                    </li>
                </ul>
            </li>
            <li>
                <a href="#">Promotion<span class="fa arrow"></span></a>

            </li>
            <li>
                <a href="#">Finance<span class="fa arrow"></span></a>

            </li>
            <li>
                <a href="#">Reports<span class="fa arrow"></span></a>
                <ul class="nav nav-second-level">
                    <li>
                        <a href="<c:url value="/admin/report/transaction-summary-audit"/>">Transaction summary audit</a>
                    </li>
                    <li>
                        <a href="<c:url value="/admin/report/product-summary"/>">Product sale summary</a>
                    </li>

                    <li>
                        <a href="<c:url value="/admin/report/performance"/>">Performance</a>
                    </li>
                    <li>
                        <a href="<c:url value="/admin/report/distributor"/>">Distributor</a>
                    </li>
                    <li>
                        <a href="<c:url value="/admin/report/film"/>">Film</a>
                    </li>
                    <li>
                        <a href="<c:url value="/admin/report/film"/>">Screen</a>
                    </li>
                    <li>
                        <a href="<c:url value="/admin/report/complementary"/>">Complementary</a>
                    </li>
                    <li>
                        <a href="<c:url value="/admin/report/hourly"/>">hourly</a>
                    </li>
                    <li>
                        <a href="<c:url value="/admin/report/general-rating"/>">General / Rating</a>
                    </li>
                    <li>
                        <a href="<c:url value="/admin/report/performance-listing"/>">Performance listing</a>
                    </li>
                    <li>
                        <a href="<c:url value="/admin/report/ticket-type"/>">Ticket  type</a>
                    </li>
                    <li>
                        <a href="<c:url value="/admin/report/sales-transaction"/>">Sales transaction</a>
                    </li>
                    <li>
                        <a href="<c:url value="/admin/report/transaction-summary"/>">Transaction summary</a>
                    </li>
                    <li>
                        <a href="<c:url value="/admin/report/ticket-sale-by-operator"/>">Ticket sale by operator</a>
                    </li>
                    <li>
                        <a href="<c:url value="/admin/report/ticket-sale-by-operator"/>">Ticket sale by operator</a>
                    </li>
                    <li>
                        <a href="<c:url value="/admin/report/advance-sale"/>">Advance sale</a>
                    </li>
                    <li>
                        <a href="<c:url value="/admin/report/combo-sale"/>">Combo sale</a>
                    </li>
                    <li>
                        <a href="<c:url value="/admin/report/product-sale"/>">Product sale</a>
                    </li>
                    <li>
                        <a href="<c:url value="/admin/report/retails-per-hand"/>">Retails per hand</a>
                    </li>
                    <li>
                        <a href="<c:url value="/admin/report/concession-sale-by-operator"/>">Concession sale by operator</a>
                    </li>
                    <li>
                        <a href="<c:url value="/admin/report/top-grossing-film"/>">Top grossing film</a>
                    </li>
                    <li>
                        <a href="<c:url value="/admin/report/sale-by-terminal"/>">Sale by terminal</a>
                    </li>
                    <li>
                        <a href="<c:url value="/admin/report/risk"/>">Risk</a>
                    </li>

                    <li>
                        <a href="<c:url value="/admin/report/promotion"/>">Promotion</a>
                    </li>
                    <li>
                        <a href="<c:url value="/admin/report/end-of-the-day"/>">End of the day</a>
                    </li>
                    <li>
                        <a href="<c:url value="/admin/report/end-of-the-day-operator-break-down"/>">End of the day operator break down</a>
                    </li>
                    <li>
                        <a href="<c:url value="/admin/report/automatic-reporting"/>">Automatic reporting</a>
                    </li>
                    <li>
                        <a href="<c:url value="/admin/report/tender"/>">Tender</a>
                    </li>
                    <li>
                        <a href="<c:url value="/admin/report/refund"/>">Refund</a>
                    </li>


                </ul>
            </li>
        </ul>

    </div>
    <!-- /.sidebar-collapse -->
</div>
<!-- /.navbar-static-side -->